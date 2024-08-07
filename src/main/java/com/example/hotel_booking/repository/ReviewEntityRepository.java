package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewEntityRepository extends JpaRepository<ReviewEntity, Long> {
}