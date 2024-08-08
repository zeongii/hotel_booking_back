package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.RoomDto;
import com.example.hotel_booking.dto.RoomTypeDto;
import com.example.hotel_booking.service.RoomService;
import com.example.hotel_booking.service.RoomTypeService;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/room/")
public class RoomController {

    @Autowired
    private RoomService ROOM_SERVICE;
    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    public RoomController(RoomService roomService) {
        ROOM_SERVICE=roomService;
    }

    @GetMapping("showOne/{id}")
    public RoomDto selectOne(@PathVariable Long id) {
        return ROOM_SERVICE.selectOne(id);
    }

    @GetMapping("showList/{id}")
    public HashMap<String,Object> selectList(@PathVariable Long Id) {
        HashMap<String, Object> resultMap=new HashMap<>();

        resultMap.put("roomList",ROOM_SERVICE.selectAll(Id));
        return resultMap;
    }

    @PostMapping("write/{hotelId}")
    public HashMap<String, Object> write(@PathVariable Long hotelId, @RequestBody RoomDto roomDto) {
        System.out.println(roomDto);
        roomDto.setHotelId(hotelId);
        List<RoomTypeDto> roomTypeDtoList=roomTypeService.selectAll();
        HashMap<String,Object> resultMap = new HashMap<>();
        System.out.println(roomTypeDtoList);
        try {
            ROOM_SERVICE.insert(roomDto);
            resultMap.put("result","success");
            resultMap.put("roomId",roomDto.getId());
            resultMap.put("roomTypeList",roomTypeDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result","fail");
        }
        return resultMap;
    }

    @PostMapping("update")
    public HashMap<String, Object> update (@RequestBody RoomDto roomDto,Long hotelId) {
        HashMap<String,Object> resultMap= new HashMap<>();
        ROOM_SERVICE.update(roomDto);
        resultMap.put("destRoomId",roomDto.getId());
        List<RoomTypeDto> roomTypeDtoList=roomTypeService.selectAll();
        try {
            ROOM_SERVICE.update(roomDto);
            resultMap.put("result","success");
            resultMap.put("resultRoomId",roomDto.getId());
            resultMap.put("roomTypeList",roomTypeDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result","fail");
        }
        return resultMap;
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ROOM_SERVICE.delete(id);

        return ResponseEntity.ok().build();
    }

}
