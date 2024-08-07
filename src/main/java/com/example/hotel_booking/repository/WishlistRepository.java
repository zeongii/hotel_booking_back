package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<WishlistEntity, Long> {
}