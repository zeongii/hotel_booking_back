package com.example.hotel_booking.service;


import com.example.hotel_booking.dto.ReservationDto;
import com.example.hotel_booking.entity.*;
import com.example.hotel_booking.repository.ReservationRepository;
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
            ReservationEntity reservationEntity = ReservationEntity.toInsertEntity(reservationDto, roomEntity, userEntity);
            return RESERVATION_REPOSITORY.save(reservationEntity).getId();
        }
        return null;
    }

    @Transactional
    public List<ReservationDto> selectAll(Long userId,Long roomId) {
        UserEntity userEntity = USER_REPOSITORY.findById(userId).get();
        List<ReservationEntity> reservationEntityList = RESERVATION_REPOSITORY.findAllByGuestEntity(userEntity);
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        for (ReservationEntity reservationEntity : reservationEntityList) {
            ReservationDto reservationDto = ReservationDto.toReservationDto(reservationEntity,roomId,userId);
            reservationDtoList.add(reservationDto);
        }

        return  reservationDtoList;
    }


}
