package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;

/*
 * DTO for {@link com.example.hotel_booking.entity.TripEntity}
 */
@Value
public class TripDto implements Serializable {
    Long id;
    String tripName;
    String tripContent;
}