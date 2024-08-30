package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.RoomDto;
import com.example.hotel_booking.dto.RoomFileDto;
import com.example.hotel_booking.dto.RoomTypeDto;
import com.example.hotel_booking.service.RoomFileService;
import com.example.hotel_booking.service.RoomService;
import com.example.hotel_booking.service.RoomTypeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.HashMap;
import java.util.List;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/room/")
public class RoomController {


    private final RoomService ROOM_SERVICE;
    private final RoomTypeService ROOM_TYPE_SERVICE;
    private final RoomFileService ROOM_FILE_SERVICE;

    public RoomController(RoomTypeService roomTypeService, RoomService roomService, RoomFileService roomFileService) {
        this.ROOM_TYPE_SERVICE = roomTypeService;
        this.ROOM_SERVICE = roomService;
        this.ROOM_FILE_SERVICE = roomFileService;
    }

    @GetMapping("showOne/{id}")
    public HashMap<String, Object> selectOne(@PathVariable Long id) {
        HashMap<String, Object> resultMap = new HashMap<>();
        List<RoomFileDto> roomFileDtoList = ROOM_FILE_SERVICE.findByRoomId(id);
        System.out.println(roomFileDtoList);
        resultMap.put("roomDto", ROOM_SERVICE.selectOne(id));
        resultMap.put("roomTypeList", ROOM_TYPE_SERVICE.selectAll());
        resultMap.put("roomFileDtoList", roomFileDtoList);

        System.out.println(ROOM_SERVICE.selectOne(id));
        // 호텔 아이디를 통해 userID를 빼와야함 지금은 없으니까 비교 안하고 클릭 버튼만 해놓자
        return resultMap;
    }

    @GetMapping("showList/{id}")
    public HashMap<String, Object> selectList(@PathVariable Long id) {
        HashMap<String, Object> resultMap = new HashMap<>();
        List<RoomTypeDto> roomTypeDtoList = ROOM_TYPE_SERVICE.selectAll();

        List<RoomDto> roomDtoList = ROOM_SERVICE.selectAll(id);

        for (RoomDto roomDto : roomDtoList) {
            roomDto.setImageList(ROOM_FILE_SERVICE.findByRoomIdToName(roomDto.getId()));
        }


        resultMap.put("roomTypeList", roomTypeDtoList);
        resultMap.put("roomList", roomDtoList);

        return resultMap;
    }


    @PostMapping("imgInsert/{id}")
    public void insertImg(@RequestParam(value = "file", required = false) MultipartFile[] files, @PathVariable Long id, HttpServletRequest request) throws IOException {

        System.out.println("files = " + Arrays.toString(files) + ", id = " + id);

        StringBuilder fileNames = new StringBuilder();

        Path uploadPath = Paths.get("src/main/resources/static/room/");
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

            RoomFileDto temp = new RoomFileDto();
            temp.setId(id);
            temp.setOriginalFileName(originalFileName);
            temp.setStoredFileName(storedFileName);
            temp.setExtension(extension);

            ROOM_FILE_SERVICE.save(temp, id);

        }

    }

    @PostMapping("write/{hotelId}")
    public HashMap<String, Object> write(@PathVariable Long hotelId, @RequestBody RoomDto roomDto) {
        System.out.println(roomDto);
        roomDto.setHotelId(hotelId);
        List<RoomTypeDto> roomTypeDtoList = ROOM_TYPE_SERVICE.selectAll();
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            Long id = ROOM_SERVICE.insert(roomDto);
            resultMap.put("result", "success");
            resultMap.put("roomId", id);
            resultMap.put("roomTypeList", roomTypeDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", "fail");
        }
        return resultMap;
    }

    @PostMapping("update")
    public HashMap<String, Object> update(@RequestBody RoomDto roomDto) {
        HashMap<String, Object> resultMap = new HashMap<>();
        ROOM_SERVICE.update(roomDto);
        resultMap.put("destRoomId", roomDto.getId());
        List<RoomTypeDto> roomTypeDtoList = ROOM_TYPE_SERVICE.selectAll();
        try {
            ROOM_SERVICE.update(roomDto);
            resultMap.put("result", "success");
            resultMap.put("resultRoomId", roomDto.getId());
            resultMap.put("roomTypeList", roomTypeDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", "fail");
        }
        return resultMap;
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ROOM_SERVICE.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("roomImage")
    public ResponseEntity<Resource> getImage(@RequestParam String fileName) throws IOException {
        Path filePath = Paths.get("src/main/resources/static/room").resolve(fileName);
        if (Files.exists(filePath)) {
            Resource fileResource = new UrlResource(filePath.toUri());
            return ResponseEntity.ok()
                    .body(fileResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
