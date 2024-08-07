package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestEntityRepository extends JpaRepository<GuestEntity, Long> {
}