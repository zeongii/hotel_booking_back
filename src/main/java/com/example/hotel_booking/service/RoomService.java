package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.RoomDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.entity.RoomEntity;
import com.example.hotel_booking.entity.RoomTypeEntity;
import com.example.hotel_booking.repository.HotelRepository;
import com.example.hotel_booking.repository.RoomFileRepository;
import com.example.hotel_booking.repository.RoomRepository;
import com.example.hotel_booking.repository.RoomTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class RoomService {


    private final HotelRepository HOTEL_REPOSITORY;
    private final RoomRepository ROOM_REPOSITORY;
    private final RoomFileRepository ROOM_FILE_REPOSITORY;
    private final RoomTypeRepository ROOM_TYPE_REPOSITORY;


    public RoomService(HotelRepository hotelRepository, RoomRepository roomRepository, RoomTypeRepository roomTypeRepository, RoomFileRepository roomFileRepository) {
        this.HOTEL_REPOSITORY = hotelRepository;
        this.ROOM_REPOSITORY = roomRepository;
        this.ROOM_FILE_REPOSITORY = roomFileRepository;
        this.ROOM_TYPE_REPOSITORY = roomTypeRepository;
    }

    public Long insert(RoomDto roomDto) throws IOException {

        Optional<HotelEntity> optionalHotelEntity = HOTEL_REPOSITORY.findById(roomDto.getHotelId());
        if (optionalHotelEntity.isPresent()) {
            HotelEntity hotelEntity = optionalHotelEntity.get();

            RoomTypeEntity roomTypeEntity = ROOM_TYPE_REPOSITORY.findById(roomDto.getRoomTypeId()).get();
            RoomEntity roomEntity = RoomEntity.toInsertEntity(roomDto, hotelEntity, roomTypeEntity);
            return ROOM_REPOSITORY.save(roomEntity).getId();

        }
        return null;
    }

    @Transactional
    public List<RoomDto> selectAll(Long hotelId) {
        HotelEntity hotelEntity = HOTEL_REPOSITORY.findById(hotelId).get();
        List<RoomEntity> roomEntityList = ROOM_REPOSITORY.findAllByHotelEntityOrderByIdDesc(hotelEntity);
        List<RoomDto> roomDtoList = new ArrayList<>();
        for (RoomEntity roomEntity : roomEntityList) {
            RoomDto roomDto = RoomDto.toRoomDto(roomEntity, hotelId);
            roomDtoList.add(roomDto);
        }
        return roomDtoList;
    }

    @Transactional
    public RoomDto selectOne(Long roomId) {
        Optional<RoomEntity> optionalRoomEntity = ROOM_REPOSITORY.findById(roomId);
//        System.out.println(optionalRoomEntity);
        if (optionalRoomEntity.isPresent()) {
            RoomEntity roomEntity = optionalRoomEntity.get();
            RoomDto roomDto = RoomDto.toRoomDto(roomEntity, roomEntity.getHotelEntity().getId());
            return roomDto;
        } else {
            return null;
        }
    }

    @Transactional
    public RoomDto update(RoomDto roomDto) {
        HotelEntity hotelEntity = HOTEL_REPOSITORY.findById(roomDto.getHotelId()).get();
        RoomTypeEntity roomTypeEntity = ROOM_TYPE_REPOSITORY.findById(roomDto.getRoomTypeId()).get();
        RoomEntity roomEntity = RoomEntity.toUpdateEntity(roomDto, hotelEntity, roomTypeEntity);
        ROOM_REPOSITORY.save(roomEntity);
        return selectOne(roomDto.getId());
    }

    @Transactional
    public void delete(Long id) {
        ROOM_REPOSITORY.deleteById(id);
    }


}
