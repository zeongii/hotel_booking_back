package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * DTO for {@link com.example.hotel_booking.entity.SalesEntity}
 */
@Value
public class SalesDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    LocalDateTime salesDate;
}