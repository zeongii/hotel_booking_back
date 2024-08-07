package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.GuestDto;
import com.example.hotel_booking.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guest/")
public class GuestController {
    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }


    @GetMapping("test")
    public String test() {
        return "test";
    }

    @GetMapping("update/{id}")
    public GuestDto update(@PathVariable Long id, Model model) {
        GuestDto guestDto = guestService.findById(id);
        model.addAttribute("guest", guestDto);
        return guestDto;
    }

    @PostMapping("update")
    public GuestDto update(@RequestBody GuestDto guestDto, Model model) {
        System.out.println("guestDto = " + guestDto + ", model = " + model);
        GuestDto updatedGuestDto = guestService.update(guestDto);
        model.addAttribute("guest", updatedGuestDto);
        return updatedGuestDto;
    }
}
