package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {



}