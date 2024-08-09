package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmailAndNameAndPhone(String email, String name, String phone);

    @Query("SELECT u FROM UserEntity u WHERE u.name = :name AND u.phone = :phone")
    Optional<UserEntity> findByNameAndPhone(@Param("name") String name, @Param("phone") String phone);
}
