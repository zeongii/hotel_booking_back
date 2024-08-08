package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.RoomDto;
import com.example.hotel_booking.service.RoomService;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/room/")
public class RoomController {

    private RoomService ROOM_SERVICE;

    @Autowired
    public RoomController(RoomService roomService) {
        ROOM_SERVICE=roomService;
    }

    @GetMapping("showOne/{id}")
    public RoomDto selectOne(@PathVariable Long id) {
        return ROOM_SERVICE.selectOne(id);
    }

    @GetMapping("showList")
    public HashMap<String,Object> selectList(Long hotelId) {
        HashMap<String, Object> resultMap=new HashMap<>();

        resultMap.put("roomList",ROOM_SERVICE.selectAll(hotelId));
        return resultMap;
    }

    @PostMapping("write")
    public HashMap<String, Object> write(@RequestBody RoomDto roomDto) {
        System.out.println(roomDto);
        HashMap<String,Object> resultMap = new HashMap<>();
        try {
            ROOM_SERVICE.insert(roomDto);
            resultMap.put("result","success");
            resultMap.put("roomId",roomDto.getId());
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

        try {
            ROOM_SERVICE.update(roomDto);
            resultMap.put("result","success");
            resultMap.put("resultRoomId",roomDto.getId());
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
