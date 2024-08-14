package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.FacilityDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.entity.HotelFacilityEntity;
import com.example.hotel_booking.repository.FacilityRepository;
import com.example.hotel_booking.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepository;
    private final HotelRepository hotelRepository;



    public void save(List<FacilityDto> facilityDtoList, Long hotelId) {
        Optional<HotelEntity> optionalHotelEntity = hotelRepository.findById(hotelId);
        HotelEntity hotelEntity = optionalHotelEntity.get();
        for(int i = 0 ; i < facilityDtoList.size(); i++){
            HotelFacilityEntity  hotelFacilityEntity = HotelFacilityEntity.toHotelFacilityEntity(facilityDtoList.get(i), hotelEntity);
            facilityRepository.save(hotelFacilityEntity);
        }

    }


}
