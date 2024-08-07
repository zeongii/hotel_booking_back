package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.FacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityEntityRepository extends JpaRepository<FacilityEntity, Long> {
}