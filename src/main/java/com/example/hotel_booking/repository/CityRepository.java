package com.example.hotel_booking.repository;


import com.example.hotel_booking.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Long> {
}
