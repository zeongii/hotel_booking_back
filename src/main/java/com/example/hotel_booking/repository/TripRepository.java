package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<TripEntity, Long> {
}