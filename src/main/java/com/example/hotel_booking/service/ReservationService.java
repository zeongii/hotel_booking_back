package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.ReservationDto;
import com.example.hotel_booking.entity.ReservationEntity;
import com.example.hotel_booking.entity.*;
import com.example.hotel_booking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.hotel_booking.repository.RoomRepository;
import com.example.hotel_booking.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final RoomRepository ROOM_REPOSITORY;
    private final ReservationRepository RESERVATION_REPOSITORY;
    private final UserRepository USER_REPOSITORY;

    @Autowired
    public ReservationService(RoomRepository ROOM_REPOSITORY, ReservationRepository RESERVATION_REPOSITORY, UserRepository USER_REPOSITORY) {
        this.ROOM_REPOSITORY = ROOM_REPOSITORY;
        this.RESERVATION_REPOSITORY = RESERVATION_REPOSITORY;
        this.USER_REPOSITORY = USER_REPOSITORY;
    }

    public Long insert(ReservationDto reservationDto) {
        Optional<RoomEntity> optionalRoomEntity = ROOM_REPOSITORY.findById(reservationDto.getRoomId());
        Optional<UserEntity> optionalUserEntity = USER_REPOSITORY.findById(reservationDto.getUserId());
        if (optionalRoomEntity.isPresent()) {
            RoomEntity roomEntity = optionalRoomEntity.get();
            UserEntity userEntity = optionalUserEntity.get();
            ReservationEntity reservationEntity = ReservationEntity.toInsertEntity(reservationDto,userEntity , roomEntity);
            return RESERVATION_REPOSITORY.save(reservationEntity).getId();
        }
        return null;
    }

    @Transactional
    public List<ReservationDto> selectAll(Long userId) {
        UserEntity userEntity = USER_REPOSITORY.findById(userId).get();
        List<ReservationEntity> reservationEntityList = RESERVATION_REPOSITORY.findAllByGuestEntity(userEntity);
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        for (ReservationEntity reservationEntity : reservationEntityList) {
            ReservationDto reservationDto = ReservationDto.toReservationDto(reservationEntity,reservationEntity.getGuestEntity(),reservationEntity.getRoomEntity());
            reservationDtoList.add(reservationDto);
        }

        return  reservationDtoList;
    }

    @Transactional
    public ReservationDto selectOne(Long reservationId) {
        Optional<ReservationEntity> optionalReservationEntity = RESERVATION_REPOSITORY.findById(reservationId);

        if (optionalReservationEntity.isPresent()) {
            ReservationEntity reservationEntity = optionalReservationEntity.get();
            ReservationDto reservationDto = ReservationDto.toReservationDto(reservationEntity,reservationEntity.getGuestEntity(),reservationEntity.getRoomEntity());
            return reservationDto;
        } else {
            return null;
        }
    }
    // 예약 취소
    @Transactional
    public ReservationDto cancled(ReservationDto reservationDto) {
        reservationDto.setEnabled(0);

        UserEntity userEntity = USER_REPOSITORY.findById(reservationDto.getUserId()).get();
        RoomEntity roomEntity = ROOM_REPOSITORY.findById(reservationDto.getRoomId()).get();
        ReservationEntity reservationEntity = ReservationEntity.toInsertEntity(reservationDto, userEntity, roomEntity);

        RESERVATION_REPOSITORY.save(reservationEntity);


        return reservationDto;
    }

    public List<ReservationDto> findAllByGuestId(Long id) {
        List<ReservationEntity> reservationEntities = RESERVATION_REPOSITORY.findByGuestId(id);
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        for (ReservationEntity reservationEntity : reservationEntities) {
            reservationDtoList.add(ReservationDto.toReservationDto(reservationEntity));
        }
        return reservationDtoList;
    }
}
