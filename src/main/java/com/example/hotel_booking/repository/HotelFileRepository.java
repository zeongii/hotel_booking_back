package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.HotelFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelFileRepository extends JpaRepository<HotelFileEntity, Long> {
    @Query(value = "SELECT * FROM hotel_file_table WHERE id = ?1", nativeQuery = true)
    List<HotelFileEntity> findByHotelId(Long hotelId);
}
