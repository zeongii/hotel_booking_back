package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDto> searchHotel(List<Long> gradeList, List<Long> cityIdList, List<Long> facilityIdList) {
        List<Long> hotelIds = hotelRepository.findHotelsByCriteria(gradeList, cityIdList, facilityIdList);

        List<HotelDto> hotelDtoList = new ArrayList<>();
        for (Long id : hotelIds) {
            Optional<HotelEntity> hotelEntityOptional = hotelRepository.findById(id);
            hotelEntityOptional.ifPresent(hotelEntity -> {
                hotelDtoList.add(HotelDto.toHotelDto(hotelEntity));
            });
        }
        return hotelDtoList;
    }
}
