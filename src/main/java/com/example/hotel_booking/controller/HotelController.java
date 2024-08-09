package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.dto.TestDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/search/")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    //호텔 찾기
    @PostMapping("hotel")
    public Map<String, Object> searchHotel(@RequestBody Map<String, Object> data) {
        Map<String, Object> resultMap = new HashMap<>();

        List<Integer> gradeIntegerList = (List<Integer>) data.get("grade");
        List<Integer> cityIdIntegerList = (List<Integer>) data.get("cityId");

        List<Long> gradeList = new ArrayList<>();
        for (int gradeInteger : gradeIntegerList) {
            gradeList.add((long) gradeInteger);
        }
        List<Long> cityIdList = new ArrayList<>();
        for (int cityIdInteger : cityIdIntegerList) {
            cityIdList.add((long) cityIdInteger);
        }

        String hotelName = (String) data.get("hotelName");

        List<HotelDto> hotelDtoList = hotelService.searchHotel(gradeList, cityIdList, hotelName);

        resultMap.put("hotelDtoList", hotelDtoList);
        //return hotelDtoSet;
        return resultMap;
    }

}


