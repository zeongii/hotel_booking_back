package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/*
 * DTO for {@link com.example.hotel_booking.entity.ReservationEntity}
 */
@Value
public class ReservationDto implements Serializable {
    Long id;
    Date startDate;
    Date endDate;
    String reservationNumber;
    double payPrice;
    Long isBreakfast;
    int enabled;
}