package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.FacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface FacilityRepository extends JpaRepository<FacilityEntity, Long> {
    @Query(value = "SELECT hotel_id FROM facility WHERE id = ?1", nativeQuery = true)
    Collection<Long> findAllByFacilityId(Long id);
}