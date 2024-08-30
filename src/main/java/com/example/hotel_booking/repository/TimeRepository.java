package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.TimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TimeRepository<T extends TimeEntity, ID> extends JpaRepository<T, ID> {
}