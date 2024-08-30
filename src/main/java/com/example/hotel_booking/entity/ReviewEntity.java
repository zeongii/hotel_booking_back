package com.example.hotel_booking.entity;

import com.example.hotel_booking.dto.ReviewDto;
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

    @JoinColumn(name = "hotel_id")
    private Long hotelId;

    @JoinColumn(name = "user_id")
    private Long userId;

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

    public static ReviewEntity toAddReviewEntity(ReviewDto reviewDto) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setHotelId(reviewDto.getHotelId());
        reviewEntity.setUserId(reviewDto.getUserId());
        reviewEntity.setRoomType(reviewDto.getRoomType());
        reviewEntity.setReservationId(reviewDto.getReservationId());
        reviewEntity.setCleanRating(reviewDto.getCleanRating());
        reviewEntity.setTrafficRating(reviewDto.getTrafficRating());
        reviewEntity.setFacilityRating(reviewDto.getFacilityRating());
        reviewEntity.setTotalRating(reviewDto.getTotalRating());
        reviewEntity.setReviewTitle(reviewDto.getReviewTitle());
        reviewEntity.setReviewContent(reviewDto.getReviewContent());
        return reviewEntity;
    }

    public static ReviewEntity toUpdateReviewEntity(ReviewDto reviewDto) {
        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setId(reviewDto.getId());
        reviewEntity.setHotelId(reviewDto.getHotelId());
        reviewEntity.setUserId(reviewDto.getUserId());
        reviewEntity.setRoomType(reviewDto.getRoomType());
        reviewEntity.setReservationId(reviewDto.getReservationId());
        reviewEntity.setCleanRating(reviewDto.getCleanRating());
        reviewEntity.setTrafficRating(reviewDto.getTrafficRating());
        reviewEntity.setFacilityRating(reviewDto.getFacilityRating());
        reviewEntity.setTotalRating(reviewDto.getTotalRating());
        reviewEntity.setReviewTitle(reviewDto.getReviewTitle());
        reviewEntity.setReviewContent(reviewDto.getReviewContent());
        return reviewEntity;
    }
}