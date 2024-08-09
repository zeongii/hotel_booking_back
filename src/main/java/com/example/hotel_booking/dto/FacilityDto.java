package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.FacilityEntity;
import com.example.hotel_booking.entity.HotelEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/*
 * DTO for {@link com.example.hotel_booking.entity.FacilityEntity}
 */
@Data
@RequiredArgsConstructor
public class FacilityDto implements Serializable {
    private Long id;
    private Long facilityId;
    private Long hotelId;

    public static FacilityDto toFacilityDto(FacilityEntity facilityEntity, Long hotelId, Long facilityId){
        FacilityDto facilityDto = new FacilityDto();
        facilityDto.setId(facilityEntity.getId());
        facilityDto.setHotelId(hotelId);
        facilityDto.setFacilityId(facilityId);
        return facilityDto;
    }

}