package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.hotel_booking.entity.BusinessEntity}
 */
@Value
public class BusinessDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    String businessEmail;
    String businessPassword;
    String companyName;
    String companyPhone;
    String companyAddress;
    int enabled;
}