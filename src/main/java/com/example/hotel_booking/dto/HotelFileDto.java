package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.HotelFileEntity;

public class HotelFileDto {
    public static HotelFileDto toHotelFileDto(HotelFileEntity hotelFileEntity) {
        HotelFileDto hotelFileDto = new HotelFileDto();
        return hotelFileDto;
    }
}
