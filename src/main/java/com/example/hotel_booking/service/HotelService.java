package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.entity.HotelEntity;
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

    public List<HotelDto> searchHotel(List<Long> gradeList, List<Long> cityIdList
            , List<Long> facilityIdList, String hotelName) {

        List<HotelDto> hotelDtoList = new ArrayList<>();

        List<Long> hotelIdListFindByGrade = new ArrayList<>();
        if (!gradeList.isEmpty()) {
            for (Long grade : gradeList) {
                hotelIdListFindByGrade.addAll(hotelRepository.findByGrade(grade));
            }
        } else {
            hotelIdListFindByGrade = hotelRepository.findAllId();
        }

        if (hotelIdListFindByGrade.isEmpty()) {
            return null;
        }
        Collections.sort(hotelIdListFindByGrade);

        List<Long> hotelIdListFindByCity = new ArrayList<>();
        if (!cityIdList.isEmpty()) {
            for (Long cityId : cityIdList) {
                hotelIdListFindByCity.addAll(hotelRepository.findByCityId(cityId));
            }
        } else {
            hotelIdListFindByCity = hotelRepository.findAllId();
        }

        if (hotelIdListFindByCity.isEmpty()) {
            return null;
        }
        Collections.sort(hotelIdListFindByCity);

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

        if (hotelIdListFindByFacility.isEmpty()) {
            return null;
        }
        Collections.sort(hotelIdListFindByFacility);

        //Set<Long> roomTypeIdSet = new HashSet<>();

        List<Long> hotelIdListFindByHotelName;
        if (hotelName != null) {
            hotelIdListFindByHotelName = new ArrayList<>(hotelRepository.findByHotelNameContaining(hotelName));
        } else {
            hotelIdListFindByHotelName = hotelRepository.findAllId();
        }

        if (hotelIdListFindByHotelName.isEmpty()) {
            return null;
        }
        Collections.sort(hotelIdListFindByHotelName);

        int gradeIndex = 0, cityIndex = 0, facilityIndex = 0, hotelIndex = 0;

        while (gradeIndex < hotelIdListFindByGrade.size() &&
                cityIndex < hotelIdListFindByCity.size() &&
                facilityIndex < hotelIdListFindByFacility.size() &&
                hotelIndex < hotelIdListFindByHotelName.size()) {

            long gradeCurVal = hotelIdListFindByGrade.get(gradeIndex);
            long cityCurVal = hotelIdListFindByCity.get(cityIndex);
            long facilityCurVal = hotelIdListFindByFacility.get(facilityIndex);
            long hotelCurVal = hotelIdListFindByHotelName.get(hotelIndex);

            if (gradeCurVal == cityCurVal &&
                    cityCurVal == facilityCurVal &&
                    facilityCurVal == hotelCurVal) {
                HotelDto tempHotelDto = HotelDto.toHotelDto(hotelRepository.findById(gradeCurVal));

                hotelDtoList.add(tempHotelDto);
                gradeIndex++;
                cityIndex++;
                facilityIndex++;
                hotelIndex++;
            } else {
                long tempMin1 = Math.min(gradeCurVal, cityCurVal);
                long tempMin2 = Math.min(facilityCurVal, hotelCurVal);
                long minVal = Math.min(tempMin1, tempMin2);

                if (gradeCurVal == minVal)
                    gradeIndex++;
                if (cityCurVal == minVal)
                    cityIndex++;
                if (facilityCurVal == minVal)
                    facilityIndex++;
                if (hotelCurVal == minVal)
                    hotelIndex++;
            }
        }

//        for (Long id : hotelIdListFindByGrade) {
//            if (hotelIdListFindByCity.contains(id) &&
//                    hotelIdListFindByHotelName.contains(id) &&
//                    hotelIdListFindByFacility.contains(id)) {
//                hotelDtoList.add(HotelDto.toHotelDto(hotelRepository.findById(id)));
//            }
//        }
        System.out.println("gradeList: " + hotelIdListFindByGrade);
        System.out.println("cityList: " + hotelIdListFindByCity);
        System.out.println("facilityList: " + hotelIdListFindByFacility);
        System.out.println("nameList: " + hotelIdListFindByHotelName);
        System.out.println(facilityIdList);
//        for (HotelDto hotelDto : hotelDtoList) {
//            System.out.println(hotelDto.toString());
//        }
        return hotelDtoList;
    }
}
