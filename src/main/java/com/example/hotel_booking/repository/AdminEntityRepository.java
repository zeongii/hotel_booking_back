package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminEntityRepository extends JpaRepository<AdminEntity, Long> {
}