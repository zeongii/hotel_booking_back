package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.entity.HotelFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelFileRepository extends JpaRepository<HotelFileEntity, Long> {

    List<HotelFileEntity> findByHotelEntity_id(Long hotelId);

}
