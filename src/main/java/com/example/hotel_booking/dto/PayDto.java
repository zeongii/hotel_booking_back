package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * DTO for {@link com.example.hotel_booking.entity.PayEntity}
 */
@Value
public class PayDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    Long payPrice;
    LocalDateTime payDate;
    String payWay;
}