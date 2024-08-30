package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u WHERE u.name = :name AND u.phone = :phone")
    Optional<UserEntity> findByNameAndPhone(@Param("name") String name, @Param("phone") String phone);


    Optional<UserEntity> findByEmailAndNameAndPhone(String email, String name, String phone);

    Optional<UserEntity> findByEmail(String email);


    @Query("SELECT u.visitorCount FROM UserEntity u WHERE u.id = ?1")
    Long findVisitorCountByUserId(Long userId);

    @Modifying
    @Transactional
    @Query("UPDATE UserEntity u SET u.visitorCount = ?1 WHERE u.id = ?2")
    void updateVisitorCount(Long visitorCount, Long userId);

    // 모든  회원을 중복 없이 가져오기
    @Query("SELECT COUNT(DISTINCT u.id) FROM UserEntity u WHERE u.role IN :roles")
    int countUsersByRoles(@Param("roles") List<String> roles);
}

