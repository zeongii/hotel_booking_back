package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelEntityRepository extends JpaRepository<HotelEntity, Long> {
}