package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.hotel_booking.entity.HotelEntity}
 */
@Value
public class HotelDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    String hotelName;
    String hotelAddress;
    String hotelPhone;
    String hotelEmail;
    Long hotelGrade;
    String hotelFacilities;
}