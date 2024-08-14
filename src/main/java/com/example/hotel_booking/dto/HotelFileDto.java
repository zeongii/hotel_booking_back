package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.entity.HotelFileEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelFileDto {
    private Long id;

    private String originalFileName;

    private String storedFileName;

    private String extension;

    private Long hotelId;

    public static HotelFileDto toHotelFileDto(HotelFileEntity hotelFileEntity, Long hotelId){
        HotelFileDto hotelFileDto = new HotelFileDto();
        hotelFileDto.setId(hotelFileEntity.getId());
        hotelFileDto.setOriginalFileName(hotelFileEntity.getOriginalFileName());
        hotelFileDto.setStoredFileName(hotelFileEntity.getStoredFileName());
        hotelFileDto.setHotelId(hotelId);

        return hotelFileDto;
    }
}
