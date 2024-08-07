package com.example.hotel_booking.service;

import com.example.hotel_booking.repository.ReservationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    ReservationEntityRepository reservationEntityRepository;

    @Autowired
    public ReservationService(ReservationEntityRepository reservationEntityRepository) {
        this.reservationEntityRepository = reservationEntityRepository;
    }
}
