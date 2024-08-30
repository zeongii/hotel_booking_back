package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<SalesEntity, Long> {
}