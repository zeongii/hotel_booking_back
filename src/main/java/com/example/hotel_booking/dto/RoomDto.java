package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.hotel_booking.entity.RoomEntity}
 */
@Value
public class RoomDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    String roomName;
    Long roomMax;
    Long roomPrice;
    String roomContent;
    LocalDateTime checkIn;
    LocalDateTime checkOut;
    Long breakfastPrice;
}