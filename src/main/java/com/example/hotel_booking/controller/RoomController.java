package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.RoomDto;
import com.example.hotel_booking.dto.RoomTypeDto;
import com.example.hotel_booking.service.RoomService;
import com.example.hotel_booking.service.RoomTypeService;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/room/")
public class RoomController {


    private final RoomService ROOM_SERVICE;
    private final RoomTypeService ROOM_TYPE_SERVICE;

    public RoomController(RoomTypeService roomTypeService, RoomService ROOM_SERVICE) {
        this.ROOM_TYPE_SERVICE = roomTypeService;
        this.ROOM_SERVICE = ROOM_SERVICE;
    }

    @GetMapping("showOne/{id}")
    public HashMap<String,Object> selectOne(@PathVariable Long id) {
        HashMap<String,Object> resultMap=new HashMap<>();
        resultMap.put("roomDto",ROOM_SERVICE.selectOne(id));
        resultMap.put("roomTypeList",ROOM_TYPE_SERVICE.selectAll());
        System.out.println(ROOM_SERVICE.selectOne(id));
        // 호텔 아이디를 통해 userID를 빼와야함 지금은 없으니까 비교 안하고 클릭 버튼만 해놓자
        return resultMap;
    }

    @GetMapping("showList/{id}")
    public HashMap<String,Object> selectList(@PathVariable Long id) {
        HashMap<String, Object> resultMap=new HashMap<>();
        List<RoomTypeDto> roomTypeDtoList=ROOM_TYPE_SERVICE.selectAll();
        resultMap.put("roomTypeList",roomTypeDtoList);
        resultMap.put("roomList",ROOM_SERVICE.selectAll(id));
        return resultMap;
    }


    @GetMapping("write/{hotelId}")
    public RoomDto write(@PathVariable Long hotelId) {
        RoomDto roomDto = new RoomDto();
        roomDto.setHotelId(1L);
        System.out.println(roomDto);
        return roomDto;
    }

    @PostMapping("write/{hotelId}")
    public HashMap<String, Object> write(@PathVariable Long hotelId, @RequestBody RoomDto roomDto) {
        System.out.println(roomDto);
        roomDto.setHotelId(hotelId);
        List<RoomTypeDto> roomTypeDtoList=ROOM_TYPE_SERVICE.selectAll();
        HashMap<String,Object> resultMap = new HashMap<>();
        try {
            Long id = ROOM_SERVICE.insert(roomDto);
            resultMap.put("result","success");
            resultMap.put("roomId",id);
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
        List<RoomTypeDto> roomTypeDtoList=ROOM_TYPE_SERVICE.selectAll();
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
