package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.ReservationEntity;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/*
 * DTO for {@link com.example.hotel_booking.entity.ReservationEntity}
 */
@Data
public class ReservationDto implements Serializable {
    Long id;
    Date startDate;
    Date endDate;
    String reservationNumber;
    double payPrice;
    Long isBreakfast;
    int enabled;

    public static ReservationDto toReservationDto(ReservationEntity reservationEntity) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservationEntity.getId());
        reservationDto.setStartDate(reservationEntity.getStartDate());
        reservationDto.setEndDate(reservationEntity.getEndDate());
        reservationDto.setReservationNumber(reservationEntity.getReservationNumber());
        reservationDto.setPayPrice(reservationEntity.getPayPrice());
        reservationDto.setIsBreakfast(reservationEntity.getIsBreakfast());
        reservationDto.setEnabled(reservationEntity.getEnabled());
        return reservationDto;
    }
}