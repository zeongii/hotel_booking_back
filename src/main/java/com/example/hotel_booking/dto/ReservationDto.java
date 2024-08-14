package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.ReservationEntity;
import lombok.Data;
import lombok.Value;
import com.example.hotel_booking.entity.ReservationEntity;
import com.example.hotel_booking.entity.RoomEntity;
import com.example.hotel_booking.entity.UserEntity;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.example.hotel_booking.entity.ReservationEntity}
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto implements Serializable {
    private Long id;
    private Date startDate;
    private Date endDate;
    private String reservationNumber;
    private double payPrice;
    private Long isBreakfast;
    private int enabled;
    // 0 :
    private Long roomId;
    private Long userId;

    public static ReservationDto toReservationDto(ReservationEntity reservationEntity, UserEntity userEntity, RoomEntity roomEntity) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservationEntity.getId());
        reservationDto.setStartDate(reservationEntity.getStartDate());
        reservationDto.setEndDate(reservationEntity.getEndDate());
        reservationDto.setReservationNumber(reservationEntity.getReservationNumber());
        reservationDto.setPayPrice(reservationEntity.getPayPrice());
        reservationDto.setIsBreakfast(reservationEntity.getIsBreakfast());
        reservationDto.setEnabled(reservationEntity.getEnabled());
        reservationDto.setRoomId(roomEntity.getId());
        reservationDto.setUserId(userEntity.getId());
        return reservationDto;
    }

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