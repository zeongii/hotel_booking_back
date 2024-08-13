package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.dto.HotelFileDto;
import com.example.hotel_booking.dto.TestDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.service.HotelFileService;
import com.example.hotel_booking.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/search/")
public class SearchController {
    private final HotelService hotelService;
    private final HotelFileService hotelFileService;

    @Autowired
    public SearchController(HotelService hotelService, HotelFileService hotelFileService) {
        this.hotelService = hotelService;
        this.hotelFileService = hotelFileService;
    }

    //호텔 찾기
    @PostMapping("hotel")
    public Map<String, Object> searchHotel(@RequestBody Map<String, Object> data) {
        Map<String, Object> resultMap = new HashMap<>();
        List<Integer> gradeIntegerList = (List<Integer>) data.get("grade");
        List<Integer> cityIdIntegerList = (List<Integer>) data.get("cityId");
        List<Integer> facilityIdIntegerList = (List<Integer>) data.get("facilityId");
        List<Integer> roomTypeIdIntegerList = (List<Integer>) data.get("roomTypeId");
        String hotelName = (String) data.get("hotelName");

        List<Long> gradeList = new ArrayList<>();
        if (gradeIntegerList != null) {
            for (int gradeInteger : gradeIntegerList) {
                gradeList.add((long) gradeInteger);
            }
        }

        List<Long> cityIdList = new ArrayList<>();
        if (cityIdIntegerList != null) {
            for (int cityIdInteger : cityIdIntegerList) {
                cityIdList.add((long) cityIdInteger);
            }
        }

        List<Long> facilityIdList = new ArrayList<>();
        if (facilityIdIntegerList != null) {
            for (int facilityIdInteger : facilityIdIntegerList) {
                facilityIdList.add((long) facilityIdInteger);
            }
        }

        List<Long> roomTypeIdList = new ArrayList<>();
        if (roomTypeIdIntegerList != null) {
            for (int roomTypeIdInteger : roomTypeIdIntegerList) {
                roomTypeIdList.add((long) roomTypeIdInteger);
            }
        }

        List<HotelDto> hotelDtoList = hotelService.searchHotel(gradeList, cityIdList, facilityIdList, hotelName);
        Map<Long, List<HotelFileDto>> hotelFileDtoList = hotelFileService.getThumbnailList(hotelDtoList.stream().map(HotelDto::getId).toList());

        resultMap.put("hotelDtoList", hotelDtoList);
        resultMap.put("hotelFileDtoList", hotelFileDtoList);

        return resultMap;
    }

}


