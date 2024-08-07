package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.PayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<PayEntity, Long> {
}