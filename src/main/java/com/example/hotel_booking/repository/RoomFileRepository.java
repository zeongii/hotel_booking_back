package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.RoomFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomFileRepository extends JpaRepository<RoomFileEntity, Long> {
    List<RoomFileEntity> findByRoomEntity_id(Long roomId);
}
