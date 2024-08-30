package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    List<RoomEntity> findAllByHotelEntityOrderByIdDesc(HotelEntity hotelEntity);

    @Query(value = "SELECT * FROM room WHERE hotel_id = ?1 AND room_type_id = ?2", nativeQuery = true)
    Collection<? extends RoomEntity> findByHotelIdAndRoomType(Long hotelId, int roomType);

    @Query(value = "SELECT * FROM room WHERE hotel_id = ?1", nativeQuery = true)
    List<RoomEntity> findAllByHotelId(Long hotelId);
}
