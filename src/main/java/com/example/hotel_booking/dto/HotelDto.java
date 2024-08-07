package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.HotelEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.hotel_booking.entity.HotelEntity}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HotelDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    String hotelName;
    String hotelAddress;
    String hotelPhone;
    String hotelEmail;
    Long hotelGrade;
    String hotelFacilities;

    public static HotelDto toHotelDto(HotelEntity hotelEntity){
        HotelDto hotelDto = new HotelDto();
        hotelDto.setId(hotelEntity.getId());
        hotelDto.setHotelName(hotelEntity.getHotelName());
        hotelDto.setHotelAddress(hotelEntity.getHotelAddress());
        hotelDto.setHotelEmail(hotelEntity.getHotelEmail());
        hotelDto.setHotelPhone(hotelEntity.getHotelPhone());
        hotelDto.setHotelGrade(hotelEntity.getHotelGrade());
        hotelDto.setHotelFacilities(hotelEntity.getHotelFacilities());
        return hotelDto;
    }
}