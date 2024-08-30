package com.example.hotel_booking.service;


import com.example.hotel_booking.dto.HotelFileDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.entity.HotelFileEntity;
import com.example.hotel_booking.repository.HotelFileRepository;
import com.example.hotel_booking.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelFileService {

    private final HotelRepository hotelRepository;
    private final HotelFileRepository hotelFileRepository;



    @Autowired
    public HotelFileService(HotelFileRepository hotelFileRepository, HotelRepository hotelRepository) {
        this.hotelFileRepository = hotelFileRepository;
        this.hotelRepository = hotelRepository;
    }


    public void save(HotelFileDto hotelFileDto, Long id) {
        Optional<HotelEntity> optionalHotelEntity = hotelRepository.findById(id);
        HotelEntity hotelEntity = optionalHotelEntity.get();
        HotelFileEntity hotelFileEntity = HotelFileEntity.toHotelFileEntity(hotelEntity, hotelFileDto.getOriginalFileName(), hotelFileDto.getStoredFileName());
        hotelFileRepository.save(hotelFileEntity);
    }



    public List<HotelFileDto> findByHotelId(long id) {
        List<HotelFileEntity> hotelFileEntityList = hotelFileRepository.findByHotelEntity_id(id);
        List<HotelFileDto> hotelFileDtoList = new ArrayList<>();
        for (HotelFileEntity entity : hotelFileEntityList) {
            hotelFileDtoList.add(HotelFileDto.toHotelFileDto(entity, id));

        }
        return hotelFileDtoList;
    }

    public List<String> findByHotelIdToName(Long id) {
        List<HotelFileEntity> hotelFileEntityList = hotelFileRepository.findByHotelEntity_id(id);
        List <String> hotelFileStoredNameList=new ArrayList<>();
        for (HotelFileEntity hotelFileEntity : hotelFileEntityList) {
            hotelFileStoredNameList.add(HotelFileDto.toHotelFileDto(hotelFileEntity,id).getStoredFileName());
        }
        return hotelFileStoredNameList;
    }
}