package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.ReservationDto;
import com.example.hotel_booking.dto.UserDto;
import com.example.hotel_booking.service.GuestService;
import com.example.hotel_booking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest/")
public class GuestController {
    private final GuestService guestService;
    private final ReservationService reservationService;

    @Autowired
    public GuestController(GuestService guestService, ReservationService reservationService) {
        this.guestService = guestService;
        this.reservationService = reservationService;
    }


    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("update/{id}")
    public UserDto update(@PathVariable Long id, Model model) {
        System.out.println("id = " + id + ", model = " + model);
        UserDto userDto = guestService.findById(id);
        model.addAttribute("guest", userDto);
        return userDto;
    }

    @PostMapping("update")
    public UserDto update(@RequestBody UserDto guestDto, Model model) {
        UserDto updatedGuestDto = guestService.update(guestDto);
        model.addAttribute("guest", updatedGuestDto);
        return updatedGuestDto;
    }

    @GetMapping("reservationInfo/{id}")
    public List<ReservationDto> reservationInfo(@PathVariable Long id) {
        List<ReservationDto> reservationDtoList = reservationService.findAllByGuestId(id);
        return reservationDtoList;
    }
}
