package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.HotelDto;
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

    public Set<HotelDto> searchHotel(List<Long> gradeList, List<Long> cityIdList, String hotelName) {
        Set<HotelDto> hotelDtoSet = new HashSet<>();

        for (Long gradeId : gradeList) {
            for (Long cityId : cityIdList) {
                hotelDtoSet.add(hotelRepository.search(gradeId, cityId, hotelName));
            }
        }

        return hotelDtoSet;
//        List<Long> hotelIdListFindByGrade = new ArrayList<>();
//        for (Long id : gradeList) {
//            hotelIdListFindByGrade.add(hotelRepository.findByGrade(id));
//        }
//        Collections.sort(hotelIdListFindByGrade);
//
//        List<Long> hotelIdListFindByCity = new ArrayList<>();
//        for (Long id : cityIdList) {
//            hotelIdListFindByCity.add(hotelRepository.findByCityId(id));
//        }
//        Collections.sort(hotelIdListFindByCity);
//
//        List<Long> hotelIdListFindByHotelName = new ArrayList<>();
//        hotelIdListFindByHotelName.add(hotelRepository.findByHotelNameContaining(hotelName));
//        Collections.sort(hotelIdListFindByHotelName);
//
//        int gradeIndex = 0, cityIndex = 0, hotelNameIndex = 0;
//        while (true) {
//            if (hotelIdListFindByGrade.size() >= gradeIndex
//            || hotelIdListFindByCity.size() >= cityIndex
//            || hotelIdListFindByHotelName.size() >= hotelNameIndex) {
//                break;
//            }
//
//            if (hotelI)
//        }
    }
}
