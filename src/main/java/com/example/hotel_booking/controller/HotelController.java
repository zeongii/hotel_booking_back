package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/hotel/")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("hotelAll")
    @CrossOrigin
    public HashMap<String, Object> hotelAll() {
        HashMap<String, Object> resultmap = new HashMap<>();
         resultmap.put("hotelList", hotelService.selectAll());
        System.out.println(resultmap);
        return resultmap;
    }

}
