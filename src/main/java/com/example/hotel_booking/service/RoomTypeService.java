package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.RoomTypeDto;
import com.example.hotel_booking.entity.RoomTypeEntity;
import com.example.hotel_booking.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomTypeService {

    @Autowired
    private final RoomTypeRepository roomTypeRepository;

    @Transactional
    public List<RoomTypeDto> selectAll() {
        List<RoomTypeEntity> roomTypeEntityList = roomTypeRepository.findAll();
        List<RoomTypeDto> roomTypeDtoList = new ArrayList<>();

        for (RoomTypeEntity roomTypeEntity : roomTypeEntityList) {
            roomTypeDtoList.add(RoomTypeDto.toRoomTypeDto(roomTypeEntity));
        }
        return roomTypeDtoList;
    }


}
