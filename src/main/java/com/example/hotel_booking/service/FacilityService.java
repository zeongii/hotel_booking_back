package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.FacilityDto;
import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.entity.FacilityEntity;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.repository.FacilityRepository;
import com.example.hotel_booking.repository.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepository;
    private final HotelRepository hotelRepository;


    public List<FacilityDto> selectAll(Long hotelId) {

        List<FacilityEntity> facilityEntityList = facilityRepository.findAll();
        List<FacilityDto> facilityDtoList = new ArrayList<>();

        for (FacilityEntity facilityEntity : facilityEntityList) {
            facilityDtoList.add(FacilityDto.toFacilityDto(facilityEntity, hotelId));
        }

        return facilityDtoList;
    }

    public void save(List<FacilityDto> facilityDtoList, Long hotelId) {
        Optional<HotelEntity> optionalHotelEntity = hotelRepository.findById(hotelId);
        HotelEntity hotelEntity = optionalHotelEntity.get();
        for(int i = 0 ; i < facilityDtoList.size(); i++){
            FacilityEntity facilityEntity = FacilityEntity.toFacilityEntity(facilityDtoList.get(i), hotelEntity);
            facilityRepository.save(facilityEntity);
        }

    }


}
