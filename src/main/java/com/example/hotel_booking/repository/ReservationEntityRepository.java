package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationEntityRepository extends JpaRepository<ReservationEntity, Long> {
}