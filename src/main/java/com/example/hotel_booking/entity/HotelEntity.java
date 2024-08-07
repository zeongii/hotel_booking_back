package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

/**
 * packageName : com.example.hotelbooking.entity
 * fileName    : CoInfoEntity
 * author      : jaejun
 * date        : 2024-08-06
 * description :
 * ===================================================
 * DATE             AUTHOR              NOTE
 * ---------------------------------------------------
 * 2024-08-06         jaejun
 */

@Getter
@Setter
@Entity
@Table(name = "hotel")
public class HotelEntity extends TimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 호텔 이름
    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    // 호텔 주소
    @Column(name = "hotel_address", nullable = false)
    private String hotelAddress;

    // 호텔 전화번호
    @Column(name = "hotel_phone", nullable = false)
    private String hotelPhone;

    // 호텔 이메일
    @Column(name = "hotel_email", nullable = false)
    private String hotelEmail;

    // 호텔 등급
    @Column(name = "hotel_grade", nullable = false)
    private Long hotelGrade;

    // 호텔 시설
    @Column(name = "hotel_facilities", nullable = false)
    private String hotelFacilities;

    // 도시 정보 (외래키)
    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    // 시설 정보 (외래키)
    @ManyToOne
    @JoinColumn(name = "facility_id")
    private FacilityEntity facilityEntity;

    // 사업 정보 (외래키)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity businessEntity;
}

