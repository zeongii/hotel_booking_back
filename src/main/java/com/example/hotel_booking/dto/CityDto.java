package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;

/*
 * DTO for {@link com.example.hotel_booking.entity.CityEntity}
 */
@Value
public class CityDto implements Serializable {
    private Long id;
    private String cityName;
}