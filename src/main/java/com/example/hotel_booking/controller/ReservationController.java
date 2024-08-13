package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.ReservationDto;
import com.example.hotel_booking.service.ReservationService;
import com.example.hotel_booking.service.RoomService;
import com.example.hotel_booking.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/reservation/")
public class ReservationController {

    private final ReservationService RESERVATION_SERVICE;
    private final UserService USER_SERVICE;
    private final RoomService ROOM_SERVICE;

    public ReservationController(ReservationService RESERVATION_SERVICE, UserService USER_SERVICE, RoomService ROOM_SERVICE) {
        this.RESERVATION_SERVICE = RESERVATION_SERVICE;
        this.USER_SERVICE = USER_SERVICE;
        this.ROOM_SERVICE = ROOM_SERVICE;
    }

    @GetMapping("showOne/{id}")
    public HashMap<String, Object> selectOne(@PathVariable Long id) {
        HashMap<String, Object> resultMap = new HashMap<>();
        ReservationDto reservationDto = RESERVATION_SERVICE.selectOne(id);
        resultMap.put("reservationDto", reservationDto);
        return resultMap;
    }
}
