package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.ReservationDto;
import com.example.hotel_booking.dto.RoomDto;
import com.example.hotel_booking.dto.RoomFileDto;
import com.example.hotel_booking.service.*;
import org.springframework.web.bind.annotation.*;
import com.example.hotel_booking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reservation/")
public class ReservationController {
    ReservationService reservationService;

    private final ReservationService RESERVATION_SERVICE;
    private final UserService USER_SERVICE;
    private final RoomService ROOM_SERVICE;
    private final RoomFileService ROOM_FILE_SERVICE;
    private final RoomTypeService ROOM_TYPE_SERVICE;

    public ReservationController(ReservationService RESERVATION_SERVICE, UserService USER_SERVICE, RoomService ROOM_SERVICE, RoomFileService ROOM_FILE_SERVICE, RoomTypeService ROOM_TYPE_SERVICE) {
        this.RESERVATION_SERVICE = RESERVATION_SERVICE;
        this.USER_SERVICE = USER_SERVICE;
        this.ROOM_SERVICE = ROOM_SERVICE;
        this.ROOM_FILE_SERVICE = ROOM_FILE_SERVICE;
        this.ROOM_TYPE_SERVICE = ROOM_TYPE_SERVICE;
    }


    @GetMapping("showOne/{id}")
    public HashMap<String, Object> selectOne(@PathVariable Long id) {
        HashMap<String, Object> resultMap = new HashMap<>();
        // 예약정보
        ReservationDto reservationDto = RESERVATION_SERVICE.selectOne(id);
        // 예약한 방 정보
        RoomDto roomDto = ROOM_SERVICE.selectOne(reservationDto.getRoomId());

        // 예약한 방 사진
        List<RoomFileDto> roomFileDtoList = ROOM_FILE_SERVICE.findByRoomId(reservationDto.getRoomId());

        resultMap.put("reservationDto", reservationDto);
        resultMap.put("roomDto", roomDto);
        resultMap.put("roomTypeList", ROOM_TYPE_SERVICE.selectAll());
        resultMap.put("roomFileDtoList", roomFileDtoList);

        return resultMap;
    }

    @PostMapping("roomReservation/{roomId}")
    public HashMap<String, Object> write(@PathVariable Long roomId, @RequestBody ReservationDto reservationDto) {
        reservationDto.setRoomId(roomId);
        // 유저 정보는 가져와야하니까 로그인된 사람이 예약눌렀을때 로그인된 아이디의 id값을 출력해야함
        reservationDto.setUserId(1L);
        String reservationNum = String.valueOf(System.currentTimeMillis());
        reservationDto.setReservationNumber(reservationNum);
        // 가격은 계산 나중에 다시 설정
        // 방 가격
        // endDate-startDate= 2   얘네를 스트링으로 받아와서 인티저로 바꿔 그다음에
        reservationDto.setPayPrice(ROOM_SERVICE.selectOne(roomId).getRoomPrice() * 2);
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            Long reservationId = RESERVATION_SERVICE.insert(reservationDto);

            resultMap.put("result", "success");
            resultMap.put("reservationId", reservationId);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", "fail");
        }
        return resultMap;
    }
}

