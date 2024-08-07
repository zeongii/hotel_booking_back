package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;

/*
 * DTO for {@link com.example.hotel_booking.entity.RoomTypeEntity}
 */
@Value
public class RoomTypeDto implements Serializable {
    Long id;
    String typeName;
    String typeContent;
}