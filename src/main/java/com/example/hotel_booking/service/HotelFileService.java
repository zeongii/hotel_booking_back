package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.FacilityDto;
import com.example.hotel_booking.dto.HotelDto;
import com.example.hotel_booking.dto.HotelFileDto;
import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.entity.HotelFacilityEntity;
import com.example.hotel_booking.entity.HotelFileEntity;
import com.example.hotel_booking.repository.CityRepository;
import com.example.hotel_booking.repository.HotelFileRepository;
import com.example.hotel_booking.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelFileService {

    private final HotelRepository hotelRepository;
    private final HotelFileRepository hotelFileRepository;

    private String uploadDir = "src/main/resources/uploads/hotel";


    public void save(HotelFileDto hotelFileDto, Long id) {
        Optional<HotelEntity> optionalHotelEntity = hotelRepository.findById(id);
        HotelEntity hotelEntity = optionalHotelEntity.get();
        HotelFileEntity hotelFileEntity = HotelFileEntity.toHotelFileEntity(hotelFileDto, hotelEntity);
        hotelFileRepository.save(hotelFileEntity);
    }

    public List<HotelFileDto> findByHotelId(long id) {
        List<HotelFileEntity> hotelFileEntityList = hotelFileRepository.findByHotelEntity_id(id);
        List <HotelFileDto> hotelFileDtoList = new ArrayList<>();
        for (HotelFileEntity entity : hotelFileEntityList) {
            hotelFileDtoList.add(HotelFileDto.toHotelFileDto(entity, id));

        }
        return hotelFileDtoList;
    }




}






