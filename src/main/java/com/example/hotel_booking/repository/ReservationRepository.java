package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.ReservationEntity;
import com.example.hotel_booking.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findAllByGuestEntity(UserEntity userEntity);
}