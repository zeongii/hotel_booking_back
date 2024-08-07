package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.BusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessEntityRepository extends JpaRepository<BusinessEntity, Long> {
}