package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * DTO for {@link com.example.hotel_booking.entity.TimeEntity}
 */
@Value
public class TimeDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
}