package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.entity.CityEntity;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.repository.CityRepository;
import com.example.hotel_booking.repository.HotelFileRepository;
import com.example.hotel_booking.repository.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final CityRepository cityRepository;

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

    public Long save(HotelDto hotelDto) {
        CityEntity cityEntity = cityRepository.findById(hotelDto.getCityId()).get();
        HotelEntity hotelEntity = HotelEntity.toHotelEntity(hotelDto, cityEntity);
            HotelEntity hotel = hotelRepository.save(hotelEntity);
            return hotel.getId();
    }


    @Transactional
    public ResponseEntity<Void> delete(Long id) {
        hotelRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
