package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.repository.HotelEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelEntityRepository hotelEntityRepository;

    public List<HotelDto> selectAll() {
        List<HotelEntity> hotelEntityList = hotelEntityRepository.findAll();
        List <HotelDto> hotelDtoList = new ArrayList<>();
        for (HotelEntity hotelEntity : hotelEntityList){
            hotelDtoList.add(HotelDto.toHotelDto(hotelEntity));
        }
        return hotelDtoList;
    }
}
