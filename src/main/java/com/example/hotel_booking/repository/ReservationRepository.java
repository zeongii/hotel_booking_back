package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.ReservationEntity;
import com.example.hotel_booking.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    @Query(value = "SELECT * FROM room_reservation WHERE user_id = ?1 ORDER BY start_date", nativeQuery = true)
    List<ReservationEntity> findByGuestId(Long userId);

    List<ReservationEntity> findAllByGuestEntity(UserEntity userEntity);
}