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
    Long cityId;

    public static HotelDto toHotelDto(Optional<HotelEntity> hotelEntityOptional) {
        HotelDto hotelDto = new HotelDto();
        if (hotelEntityOptional.isPresent()) {
            hotelDto.setId(hotelEntityOptional.get().getId());
            hotelDto.setHotelName(hotelEntityOptional.get().getHotelName());
            hotelDto.setHotelAddress(hotelEntityOptional.get().getHotelAddress());
            hotelDto.setHotelPhone(hotelEntityOptional.get().getHotelPhone());
            hotelDto.setHotelEmail(hotelEntityOptional.get().getHotelEmail());
            hotelDto.setHotelGrade(hotelEntityOptional.get().getHotelGrade());
            hotelDto.setCityId(hotelEntityOptional.get().getCityId());

        }

        return hotelDto;
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelPhone='" + hotelPhone + '\'' +
                ", hotelEmail='" + hotelEmail + '\'' +
                ", hotelGrade=" + hotelGrade +
                ", hotelFacilities='" + hotelFacilities + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}