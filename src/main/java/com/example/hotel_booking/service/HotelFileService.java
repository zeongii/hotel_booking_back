package com.example.hotel_booking.service;


import com.example.hotel_booking.dto.HotelFileDto;
import com.example.hotel_booking.entity.HotelFileEntity;
import com.example.hotel_booking.repository.HotelFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HotelFileService {
    private final HotelFileRepository hotelFileRepository;

    @Autowired
    public HotelFileService(HotelFileRepository hotelFileRepository) {
        this.hotelFileRepository = hotelFileRepository;
    }


    public Map<Long, List<HotelFileDto>> getThumbnailList(List<Long> hotelIdList) {
        Map<Long, List<HotelFileDto>> map = new HashMap<>();

        for (Long hotelId : hotelIdList) {
            List<HotelFileEntity> tempHotelFileEntityList = hotelFileRepository.findByHotelId(hotelId);

            List<HotelFileDto> hotelFileDtoList = new ArrayList<>();
            for (HotelFileEntity hotelFileEntity : tempHotelFileEntityList) {
                HotelFileDto tempHotelFileDto = HotelFileDto.toHotelFileDto(hotelFileEntity);
                hotelFileDtoList.add(tempHotelFileDto);
            }

            map.put(hotelId, hotelFileDtoList);
        }

        return map;
    }
}
