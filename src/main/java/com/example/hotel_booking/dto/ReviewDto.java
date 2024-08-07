package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.hotel_booking.entity.ReviewEntity}
 */
@Value
public class ReviewDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    Long roomType;
    Long reservationId;
    Long cleanRating;
    Long trafficRating;
    Long facilityRating;
    double totalRating;
    String reviewTitle;
    String reviewContent;
}