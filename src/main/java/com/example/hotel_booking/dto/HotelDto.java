package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.HotelEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

/*
 * DTO for {@link com.example.hotel_booking.entity.HotelEntity}
 */

@Getter
@Setter
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

    // HotelEntity를 받아서 HotelDto로 변환하는 메서드

    public static HotelDto toHotelDto(HotelEntity hotelEntity) {
        if (hotelEntity == null) {
            return null; // 호텔 엔티티가 null인 경우 null을 반환
        }
        HotelDto hotelDto = new HotelDto();

        hotelDto.setId(hotelEntity.getId());
        hotelDto.setHotelName(hotelEntity.getHotelName());
        hotelDto.setHotelAddress(hotelEntity.getHotelAddress());
        hotelDto.setHotelPhone(hotelEntity.getHotelPhone());
        hotelDto.setHotelEmail(hotelEntity.getHotelEmail());
        hotelDto.setHotelGrade(hotelEntity.getHotelGrade());

        return hotelDto;
    }



}