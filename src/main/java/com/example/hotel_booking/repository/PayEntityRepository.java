package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.PayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayEntityRepository extends JpaRepository<PayEntity, Long> {
}