package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.RoomFileDto;
import com.example.hotel_booking.entity.RoomEntity;
import com.example.hotel_booking.entity.RoomFileEntity;
import com.example.hotel_booking.repository.RoomFileRepository;
import com.example.hotel_booking.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomFileService {

    private final RoomRepository ROOM_REPOSITORY;
    private final RoomFileRepository ROOM_FILE_REPOSITORY;

    public void save(RoomFileDto roomFileDto, Long roomId) {
        Optional<RoomEntity> optionalRoomEntity = ROOM_REPOSITORY.findById(roomId);
        RoomEntity roomEntity=optionalRoomEntity.get();
        RoomFileEntity roomFileEntity=RoomFileEntity.toRoomFileEntity(roomFileDto,roomEntity);
        ROOM_FILE_REPOSITORY.save(roomFileEntity);

    }

    public List<RoomFileDto> findByRoomId(Long id) {
        List<RoomFileEntity> roomFileEntityList = ROOM_FILE_REPOSITORY.findByRoomEntity_id(id);
        List<RoomFileDto> roomFileDtoList=new ArrayList<>();
        for (RoomFileEntity roomFileEntity : roomFileEntityList) {
            roomFileDtoList.add(RoomFileDto.toRoomFileDto(roomFileEntity,id));
        }
        return roomFileDtoList;
    }
}
