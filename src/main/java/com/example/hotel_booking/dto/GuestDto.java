package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.hotel_booking.entity.GuestEntity}
 */
@Value
public class GuestDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    String guestEmail;
    String guestPass;
    String guestName;
    String guestGender;
    String guestPhone;
    int guestGrade;
    Long guestTotalAmount;
}