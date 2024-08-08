package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/hotel/")
@RequiredArgsConstructor
@CrossOrigin
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("hotelAll")
    public HashMap<String, Object> hotelAll() {
        HashMap<String, Object> resultmap = new HashMap<>();
         resultmap.put("hotelList", hotelService.selectAll());
        System.out.println(resultmap);
        return resultmap;
    }

    @GetMapping("hotelOne")
    public HotelDto selectOne(@PathVariable Long id, Model model){
        return hotelService.findById(id);

    }

}
