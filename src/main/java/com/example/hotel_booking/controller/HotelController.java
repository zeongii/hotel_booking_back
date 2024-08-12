package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.FacilityDto;
import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.dto.HotelFileDto;
import com.example.hotel_booking.service.FacilityService;
import com.example.hotel_booking.service.HotelFileService;
import com.example.hotel_booking.service.HotelService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.sql.In;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@RestController
@RequestMapping("/hotel/")
@RequiredArgsConstructor
@CrossOrigin
public class HotelController {
    private final HotelService hotelService;
    private final FacilityService facilityService;
    private final HotelFileService hotelFileService;

    @GetMapping("hotelAll")
    public HashMap<String, Object> hotelAll() {
        HashMap<String, Object> resultmap = new HashMap<>();
        resultmap.put("hotelList", hotelService.selectAll());
        System.out.println(resultmap);
        return resultmap;
    }

    @GetMapping("hotelOne/{id}")
    public HotelDto selectOne(@PathVariable Long id) {
        return hotelService.findById(id);
    }

    @PostMapping("insert")
    public HashMap<String, Object> write(@RequestBody HashMap<String, Object> valueMap) {
        System.out.println(valueMap);
        HotelDto hotelDto = new HotelDto();
        hotelDto.setHotelName((String) valueMap.get("hotelName"));
        hotelDto.setHotelEmail((String) valueMap.get("hotelEmail"));
        hotelDto.setHotelPhone((String) valueMap.get("hotelPhone"));
        hotelDto.setHotelAddress((String) valueMap.get("hotelAddress"));
        System.out.println(valueMap.get("hotelGrade").toString());
        int hotelGrade = Integer.parseInt(valueMap.get("hotelGrade").toString());
        int cityId = Integer.parseInt(valueMap.get("cityId").toString());


        hotelDto.setHotelGrade((long) hotelGrade);
        hotelDto.setCityId((long) cityId);


        Long id = hotelService.save(hotelDto);


        List<FacilityDto> facilityDtoList = new ArrayList<>();
        System.out.println(valueMap.get("facilities").getClass());

        List<Integer> facilityList = (ArrayList<Integer>) valueMap.get("facilities");
        for (int i = 0; i < facilityList.size(); i++) {
            FacilityDto temp = new FacilityDto();
            temp.setHotelId(id);
            temp.setFacilityId(facilityList.get(i).longValue());
            facilityDtoList.add(temp);
        }

        facilityService.save(facilityDtoList, id);
        System.out.println(facilityList);

        System.out.println("HotelController.write");

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", hotelDto);
        resultMap.put("resultId", id);

        return resultMap;

    }

    @GetMapping("delete/{id}")
    public void deleteHotel(@PathVariable Long id) {
        System.out.println("id = " + id);
        hotelService.delete(id);
    }

    @PostMapping("imgInsert/{id}")
    public void insertImg(@RequestParam(value = "file", required = false) MultipartFile[] files, @RequestParam Long id, HttpServletRequest request) throws IOException {
        System.out.println("HotelController.insertImg");
        System.out.println("files = " + Arrays.toString(files) + ", id = " + id);

        StringBuilder fileNames = new StringBuilder();

        Path uploadPath = Paths.get("src/main/resources/uploads");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }


        for (MultipartFile file : files) {
            String originalFileName = file.getOriginalFilename();
            long fileSize = file.getSize();
            String extension = "";

            if (originalFileName != null && originalFileName.contains(".")) {
                extension = originalFileName.substring(originalFileName.lastIndexOf('.') + 1);
            }

            String storedFileName = System.currentTimeMillis() + "." + extension;
            fileNames.append(",").append(storedFileName);

            Path filePath = uploadPath.resolve(storedFileName);
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

            }

            HotelFileDto temp = new HotelFileDto();
            temp.setId(id);
            temp.setOriginalFileName(originalFileName);
            temp.setStoredFileName(storedFileName);
            temp.setExtension(extension);

            System.out.println(temp);

            hotelFileService.save(temp, id);

        }

    }


}
