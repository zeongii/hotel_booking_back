package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.BusinessDto;
import com.example.hotel_booking.entity.BusinessEntity;
import com.example.hotel_booking.repository.BusinessEntityRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BusinessService {

    private final BusinessEntityRepository businessRepository;

    public BusinessDto selectByEmail(String Email) {
        Optional<BusinessEntity> byBusinessEmail = businessRepository.findByUsername(Email);
        BusinessDto businessDto= BusinessDto.toBusinessDto(byBusinessEmail.get());
        if(byBusinessEmail.isPresent()){
            return null;
        } else{
            return businessDto;
        }
    }
}
