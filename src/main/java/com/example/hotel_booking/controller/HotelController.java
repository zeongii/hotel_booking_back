package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.dto.TestDto;
import com.example.hotel_booking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public Set<HotelDto> searchHotel(@RequestBody Map<String, Object> data) {
        List<Long> gradeList = (List<Long>) data.get("grade");
        List<Long> cityIdList = (List<Long>) data.get("cityId");
        //List<Long> facilityIdList = (List<Long>) data.get("facilityId");
        String hotelName = (String) data.get("hotelName");

        Set<HotelDto> hotelDtoSet = hotelService.searchHotel(gradeList, cityIdList, hotelName);

        return hotelDtoSet;
    }

}


