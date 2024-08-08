package com.example.hotel_booking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.hotel_booking.entity.FacilityEntity}
 */
@Data
@RequiredArgsConstructor
public class FacilityDto implements Serializable {
    private Long id;
    private Long hotelId;

}