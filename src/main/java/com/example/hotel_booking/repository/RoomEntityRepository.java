package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomEntityRepository extends JpaRepository<RoomEntity, Long> {
}