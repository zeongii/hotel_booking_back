package com.example.hotel_booking.repository;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    @Query(value = "SELECT * FROM hotel WHERE hotel_grade = ?1 AND city_id = ?2 AND hotel_name = ?3", nativeQuery = true)
    HotelDto search(Long gradeId, Long cityId, String hotelName);
//    @Query(value = "SELECT id FROM hotel WHERE hotel_grade = ?1", nativeQuery = true)
//    Long findByGrade(Long id);
//
//    @Query(value = "SELECT id FROM hotel WHERE city_id = ?1", nativeQuery = true)
//    Long findByCityId(Long id);
//
//    @Query(value = "SELECT id FROM hotel WHERE hotel_name LIKE ?1", nativeQuery = true)
//    Long findByHotelNameContaining(String hotelName);


}