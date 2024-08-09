package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.HotelFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelFileRepository extends JpaRepository<HotelFileEntity, Long> {
}
