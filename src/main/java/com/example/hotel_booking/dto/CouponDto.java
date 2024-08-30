package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * DTO for {@link com.example.hotel_booking.entity.CouponEntity}
 */
@Value
public class CouponDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    String couName;
    String couType;
    Long couValue;
    boolean enabled;
}