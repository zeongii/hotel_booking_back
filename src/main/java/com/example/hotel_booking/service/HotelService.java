package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDto> searchHotel(List<Long> gradeList, List<Long> cityIdList, String hotelName) {
        List<HotelDto> hotelDtoList = new ArrayList<>();

        List<Long> hotelIdListFindByGrade = new ArrayList<>();
        if (gradeList != null) {
            for (Long id : gradeList) {
                hotelIdListFindByGrade.addAll(hotelRepository.findByGrade(id));
            }
        } else {
            hotelIdListFindByGrade = hotelRepository.findAllId();
        }

        List<Long> hotelIdListFindByCity = new ArrayList<>();
        if (cityIdList != null) {
            for (Long id : cityIdList) {
                hotelIdListFindByCity.addAll(hotelRepository.findByCityId(id));
            }
        } else {
            hotelIdListFindByCity = hotelRepository.findAllId();
        }

        List<Long> hotelIdListFindByHotelName = new ArrayList<>();
        if (hotelName != null) {
            hotelIdListFindByHotelName.addAll(hotelRepository.findByHotelNameContaining(hotelName));
        } else {
            hotelIdListFindByHotelName = hotelRepository.findAllId();
        }

        System.out.println("gradeList: " + hotelIdListFindByGrade);
        System.out.println("cityList: " + hotelIdListFindByCity);
        System.out.println("nameList: " + hotelIdListFindByHotelName);


        if (hotelIdListFindByGrade.size() == 0 ||
                hotelIdListFindByCity.size() == 0 ||
                hotelIdListFindByHotelName.size() == 0) {
            return null;
        }

        for (Long id : hotelIdListFindByGrade) {
            if (hotelIdListFindByCity.contains(id) &&
                    hotelIdListFindByHotelName.contains(id)) {
                hotelDtoList.add(HotelDto.toHotelDto(hotelRepository.findById(id)));
            }
        }

        System.out.println("hotelDtoList: " + hotelDtoList);

        return hotelDtoList;
    }
}
