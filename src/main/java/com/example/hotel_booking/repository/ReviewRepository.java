package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    @Query(value = "SELECT * FROM hotel_review WHERE user_id = ?1", nativeQuery = true)
    List<ReviewEntity> findAllByGuestId(Long id);
}