package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
}