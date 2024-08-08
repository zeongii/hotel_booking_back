package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.ReviewEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * DTO for {@link com.example.hotel_booking.entity.ReviewEntity}
 */
//@Value
@Data
public class ReviewDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    Long hotelId;
    Long userId;
    Long roomType;
    Long reservationId;
    Long cleanRating;
    Long trafficRating;
    Long facilityRating;
    double totalRating;
    String reviewTitle;
    String reviewContent;

    public static ReviewDto toReviewDto(ReviewEntity reviewEntity) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setCreatedTime(reviewEntity.getCreatedTime());
        reviewDto.setUpdatedTime(reviewEntity.getUpdatedTime());
        reviewDto.setId(reviewEntity.getId());
        reviewDto.setHotelId(reviewEntity.getHotelId());
        reviewDto.setUserId(reviewEntity.getUserId());
        reviewDto.setRoomType(reviewEntity.getRoomType());
        reviewDto.setReservationId(reviewEntity.getReservationId());
        reviewDto.setCleanRating(reviewEntity.getCleanRating());
        reviewDto.setTrafficRating(reviewEntity.getTrafficRating());
        reviewDto.setFacilityRating(reviewEntity.getFacilityRating());
        reviewDto.setTotalRating(reviewEntity.getTotalRating());
        reviewDto.setReviewTitle(reviewEntity.getReviewTitle());
        reviewDto.setReviewContent(reviewEntity.getReviewContent());
        return reviewDto;
    }

    public double setTotalRating() {
        double totalSum = (double) (this.cleanRating + this.trafficRating + this.facilityRating);
        return totalSum / 3;
    }
}






















