package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.ReservationDto;
import com.example.hotel_booking.entity.ReservationEntity;
import com.example.hotel_booking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationDto> findAllByGuestId(Long id) {
        List<ReservationEntity> reservationEntities = reservationRepository.findByGuestId(id);
        List<ReservationDto> reservationDtos = new ArrayList<>();
        for (ReservationEntity reservationEntity : reservationEntities) {
            reservationDtos.add(ReservationDto.toReservationDto(reservationEntity));
        }
        return reservationDtos;
    }
}
