package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hotel_review")
public class ReviewEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_type")
    private Long roomType;

    @Column(name = "reservation_id")
    private Long reservationId;

    @Column(name = "clean_rating")
    private Long cleanRating;

    @Column(name = "traffic_rating")
    private Long trafficRating;

    @Column(name = "facility_rating")
    private Long facilityRating;

    @Column(name = "total_rating")
    private double totalRating;

    @Column(name = "review_title", nullable = false)
    private String reviewTitle;

    @Column(name = "review_content", nullable = false)
    private String reviewContent;
}