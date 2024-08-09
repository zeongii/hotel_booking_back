package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.RoomDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.entity.RoomEntity;
import com.example.hotel_booking.entity.RoomFileEntity;
import com.example.hotel_booking.repository.HotelRepository;
import com.example.hotel_booking.repository.RoomFileRepository;
import com.example.hotel_booking.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class RoomService {


    private final HotelRepository HOTEL_REPOSITORY;
    private final RoomRepository ROOM_REPOSITORY;
    private final RoomFileRepository ROOM_FILE_REPOSITORY;

    public RoomService(HotelRepository hotelRepository, RoomRepository roomRepository, RoomFileRepository roomFileRepository) {
        this.HOTEL_REPOSITORY = hotelRepository;
        this.ROOM_REPOSITORY = roomRepository;
        this.ROOM_FILE_REPOSITORY = roomFileRepository;
    }

    public Long insert(RoomDto roomDto) throws IOException {

        Optional<HotelEntity> optionalHotelEntity = HOTEL_REPOSITORY.findById(roomDto.getHotelId());
        if (optionalHotelEntity.isPresent()) {
            HotelEntity hotelEntity = optionalHotelEntity.get();
            if (roomDto.getFile() == null) {
                System.out.println("ajkhjkhkjhkjhkjhkj");
                RoomEntity roomEntity = RoomEntity.toInsertEntity(roomDto, hotelEntity);
                return ROOM_REPOSITORY.save(roomEntity).getId();
            } else {
                RoomEntity roomEntity = RoomEntity.toSaveFileEntity(roomDto, hotelEntity);
                Long saveId = ROOM_REPOSITORY.save(roomEntity).getId();
                RoomEntity room = ROOM_REPOSITORY.findById(saveId).get();
                for (MultipartFile roomFile : roomDto.getFile()) {
                    String originalFilename = roomFile.getOriginalFilename();
                    String storedFileName = System.currentTimeMillis() + "_" + originalFilename; //1970년 1월1일부터 얼마나 지났는지 밀리초 단위로 나타내는 친구
                    String savePath = "C:/springboot_img/" + storedFileName;
                    roomFile.transferTo(new File(savePath));

                    RoomFileEntity roomFileEntity = RoomFileEntity.toRoomFileEntity(room, originalFilename, storedFileName);
                    ROOM_FILE_REPOSITORY.save(roomFileEntity);
                }
                return room.getId();
            }

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
        RoomEntity roomEntity = RoomEntity.toUpdateEntity(roomDto, hotelEntity);
        ROOM_REPOSITORY.save(roomEntity);
        return selectOne(roomDto.getId());
    }

    @Transactional
    public void delete(Long id) {
        ROOM_REPOSITORY.deleteById(id);
    }


}
