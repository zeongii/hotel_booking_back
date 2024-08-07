package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName : com.example.hotelbooking.entity
 * fileName    : TripEntity
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
@Table(name = "hotel_trip")
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 여행지 이름
    @Column(name = "trip_name", nullable = false)
    private String tripName;

    // 여행지 소개
    @Column(name = "trip_content", nullable = false)
    private String tripContent;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private HotelEntity hotelEntity;
}
