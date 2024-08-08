package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.RoomDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.entity.RoomEntity;
import com.example.hotel_booking.entity.RoomFileEntity;
import com.example.hotel_booking.repository.HotelRepository;
import com.example.hotel_booking.repository.RoomFileRepository;
import com.example.hotel_booking.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    @Autowired
    private final HotelRepository hotelRepository;
    @Autowired
    private final RoomRepository roomRepository;
    @Autowired
    private final RoomFileRepository roomFileRepository;

    public Long insert(RoomDto roomDto) throws IOException {
        Optional<HotelEntity> optionalHotelEntity = hotelRepository.findById(roomDto.getHotelId());
        HotelEntity hotelEntity = optionalHotelEntity.get();
        if (optionalHotelEntity.isPresent()) {
            if (roomDto.getFile().isEmpty()) {
                RoomEntity roomEntity = RoomEntity.toInsertEntity(roomDto, hotelEntity);
                return roomRepository.save(roomEntity).getId();
            } else {
                RoomEntity roomEntity = RoomEntity.toSaveFileEntity(roomDto, hotelEntity);
                Long saveId = roomRepository.save(roomEntity).getId();
                RoomEntity room = roomRepository.findById(saveId).get();
                for (MultipartFile roomFile : roomDto.getFile()) {
                    String originalFilename = roomFile.getOriginalFilename();
                    String storedFileName = System.currentTimeMillis() + "_" + originalFilename; //1970년 1월1일부터 얼마나 지났는지 밀리초 단위로 나타내는 친구
                    String savePath = "C:/springboot_img/" + storedFileName;
                    roomFile.transferTo(new File(savePath));

                    RoomFileEntity roomFileEntity = RoomFileEntity.toRoomFileEntity(room, originalFilename, storedFileName);
                    return roomFileRepository.save(roomFileEntity).getId();
                }
            }
        }
        return null;
    }

    @Transactional
    public List<RoomDto> selectAll(Long hotelId) {
        HotelEntity hotelEntity= hotelRepository.findById(hotelId).get();
        List<RoomEntity> roomEntityList = roomRepository.findAllByHotelEntityOrderByIdDesc(hotelEntity);
        List<RoomDto> roomDtoList = new ArrayList<>();
        for (RoomEntity roomEntity: roomEntityList) {
            RoomDto roomDto = RoomDto.toRoomDto(roomEntity,hotelId);
            roomDtoList.add(roomDto);
        }
        return roomDtoList;
    }

    @Transactional
    public RoomDto selectOne(Long roomId) {
        Optional<RoomEntity> optionalRoomEntity = roomRepository.findById(roomId);
        if (optionalRoomEntity.isPresent()) {
            RoomEntity roomEntity = optionalRoomEntity.get();
            RoomDto roomDto = RoomDto.toRoomDto(roomEntity,roomEntity.getHotelEntity().getId());
            return roomDto;
        } else {
            return null;
        }
    }

    @Transactional
    public RoomDto update(RoomDto roomDto) {
        HotelEntity hotelEntity = hotelRepository.findById(roomDto.getHotelId()).get();
        RoomEntity roomEntity = RoomEntity.toUpdateEntity(roomDto,hotelEntity);
        roomRepository.save(roomEntity);
        return selectOne(roomDto.getId());
    }

    @Transactional
    public void delete(Long id) {
        roomRepository.deleteById(id);
    }


}
