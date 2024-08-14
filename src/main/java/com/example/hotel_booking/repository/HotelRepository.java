package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<HotelEntity, Long>, HotelRepositoryCustom {

    // 여러 조건에 따라 호텔 ID를 검색하는 메서드
    @Query("SELECT h.id FROM HotelEntity h " +
            "JOIN HotelFacilityEntity hf ON h.id = hf.hotelEntity.id " +
            "JOIN FacilityEntity f ON hf.facilityId = f.id " +
            "WHERE (:grade IS NULL OR h.hotelGrade IN :grade) " +
            "AND (:cityId IS NULL OR h.cityEntity.id IN :cityId) " +
            "AND (:facilityId IS NULL OR f.id IN :facilityId)")
    List<Long> findHotelsByCriteria(@Param("grade") List<Long> grade,
                                    @Param("cityId") List<Long> cityId,
                                    @Param("facilityId") List<Long> facilityId);



    // 모든 호텔 ID 리스트를 가져오는 메서드
    @Query(value = "SELECT id FROM hotel", nativeQuery = true)
    List<Long> findAllId();

    // 호텔의 등급에 따른 호텔 ID 리스트를 가져오는 메서드
    @Query(value = "SELECT id FROM hotel WHERE hotel_grade = :grade", nativeQuery = true)
    List<Long> findByGrade(@Param("grade") Long grade);

    // 도시 ID에 따른 호텔 ID 리스트를 가져오는 메서드
    @Query(value = "SELECT id FROM hotel WHERE city_id = :cityId", nativeQuery = true)
    List<Long> findByCityId(@Param("cityId") Long cityId);
}
