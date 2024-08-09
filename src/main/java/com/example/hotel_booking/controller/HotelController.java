package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.FacilityDto;
import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.service.FacilityService;
import com.example.hotel_booking.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.sql.In;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/hotel/")
@RequiredArgsConstructor
@CrossOrigin
public class HotelController {
    private final HotelService hotelService;
    private final FacilityService facilityService;

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
        hotelDto.setHotelGrade((long) hotelGrade);

        Long id = hotelService.save(hotelDto);


        List<FacilityDto>  facilityDtoList = new ArrayList<>();
        System.out.println(valueMap.get("facilities").getClass());

        List<Integer> facilityList = (ArrayList<Integer>)valueMap.get("facilities");
        for (int i = 0; i < facilityList.size(); i++) {
            FacilityDto temp = new FacilityDto();
            temp.setHotelId(id);
            temp.setFacilityId(facilityList.get(i).longValue());
            facilityDtoList.add(temp);
        }

         facilityService.save(facilityDtoList, id);
        System.out.println(facilityList);

        System.out.println("HotelController.write");

        return valueMap;

    }


}
