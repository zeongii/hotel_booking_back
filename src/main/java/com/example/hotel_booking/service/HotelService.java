package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.repository.FacilityRepository;
import com.example.hotel_booking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final FacilityRepository facilityRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository, FacilityRepository facilityRepository) {
        this.hotelRepository = hotelRepository;
        this.facilityRepository = facilityRepository;
    }

    public List<HotelDto> searchHotel(List<Long> gradeList, List<Long> cityIdList, List<Long> facilityIdList, String hotelName) {
        List<HotelDto> hotelDtoList = new ArrayList<>();

        List<Long> hotelIdListFindByGrade = new ArrayList<>();
        if (!gradeList.isEmpty()) {
            for (Long grade : gradeList) {
                hotelIdListFindByGrade.addAll(hotelRepository.findByGrade(grade));
            }
        } else {
            hotelIdListFindByGrade = hotelRepository.findAllId();
        }

        List<Long> hotelIdListFindByCity = new ArrayList<>();
        if (!cityIdList.isEmpty()) {
            for (Long cityId : cityIdList) {
                hotelIdListFindByCity.addAll(hotelRepository.findByCityId(cityId));
            }
        } else {
            hotelIdListFindByCity = hotelRepository.findAllId();
        }

        List<Long> hotelIdListFindByFacility = new ArrayList<>();
        if (!facilityIdList.isEmpty()) {
            for (Long facilityId : facilityIdList) {
                hotelIdListFindByFacility.addAll(facilityRepository.findAllByFacilityId(facilityId));
            }

            //key: hotel id, value: 나온 갯수
            Map<Long, Integer> hotelIdCount = new HashMap<>();
            for (Long hotelId : hotelIdListFindByFacility) {
                if (hotelIdCount.containsKey(hotelId)) {
                    hotelIdCount.put(hotelId, hotelIdCount.get(hotelId) + 1);
                } else {
                    hotelIdCount.put(hotelId, 1);
                }
            }

            for (Map.Entry<Long, Integer> entry : hotelIdCount.entrySet()) {
                if (entry.getValue() >= facilityIdList.size()) {
                    hotelIdListFindByFacility.add(entry.getKey());
                }
            }
        } else {
            hotelIdListFindByFacility = hotelRepository.findAllId();
        }

        List<Long> hotelIdListFindByHotelName = new ArrayList<>();
        if (hotelName != null) {
            hotelIdListFindByHotelName.addAll(hotelRepository.findByHotelNameContaining(hotelName));
        } else {
            hotelIdListFindByHotelName = hotelRepository.findAllId();
        }

        System.out.println("gradeList: " + hotelIdListFindByGrade);
        System.out.println("cityList: " + hotelIdListFindByCity);
        System.out.println("facilityList: " + hotelIdListFindByFacility);
        System.out.println("nameList: " + hotelIdListFindByHotelName);
        System.out.println(facilityIdList);

        if (hotelIdListFindByGrade.isEmpty() ||
                hotelIdListFindByCity.isEmpty() ||
                hotelIdListFindByHotelName.isEmpty() ||
                hotelIdListFindByFacility.isEmpty()) {
            return null;
        }
        for (Long id : hotelIdListFindByGrade) {
            if (hotelIdListFindByCity.contains(id) &&
                    hotelIdListFindByHotelName.contains(id) &&
                    hotelIdListFindByFacility.contains(id)) {
                hotelDtoList.add(HotelDto.toHotelDto(hotelRepository.findById(id)));
            }
        }

        System.out.println("hotelDtoList: " + hotelDtoList);

        return hotelDtoList;
    }
}
