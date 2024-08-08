package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<HotelDto> selectAll() {
        List<HotelEntity> hotelEntityList = hotelRepository.findAll();
        List <HotelDto> hotelDtoList = new ArrayList<>();
        for (HotelEntity hotelEntity : hotelEntityList){
            hotelDtoList.add(HotelDto.toHotelDto(hotelEntity));
        }
        return hotelDtoList;
    }

    public HotelDto findById(long id){
        Optional<HotelEntity> optionalHotelEntity = hotelRepository.findById(id);
        if(optionalHotelEntity.isPresent()){
            HotelEntity hotelEntity = optionalHotelEntity.get();
            HotelDto hotelDto = HotelDto.toHotelDto(hotelEntity);

            return hotelDto;
        } else {
            return null;
        }
    }
}
