package com.example.hotel_booking.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.hotel_booking.entity.AdminEntity}
 */
@Data
public class AdminDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    String adPass;
    String adName;
    boolean enabled;
}