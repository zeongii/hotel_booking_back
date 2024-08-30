package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelFileRepository extends JpaRepository<FileEntity, Long> {

    List<FileEntity> findByHotelEntity_id(Long hotelId);

    @Query(value = "SELECT * FROM hotel_file_table WHERE id = ?1", nativeQuery = true)
    List<FileEntity> findByHotelId(Long hotelId);
}
