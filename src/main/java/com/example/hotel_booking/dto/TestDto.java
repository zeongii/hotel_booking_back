package com.example.hotel_booking.dto;

import lombok.Data;

@Data
public class TestDto {
    Long grade;
    String hotelName;
    Long cityId;

    public TestDto(Long grade, String hotelName, Long cityId) {
        this.grade = grade;
        this.hotelName = hotelName;
        this.cityId = cityId;
    }

}
