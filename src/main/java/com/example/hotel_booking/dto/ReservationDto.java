package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.ReservationEntity;
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

    private Long roomId;
    private Long userId;

    public static ReservationDto toReservationDto(ReservationEntity reservationEntity, Long roomId, Long userId) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservationEntity.getId());
        reservationDto.setStartDate(reservationEntity.getStartDate());
        reservationDto.setEndDate(reservationEntity.getEndDate());
        reservationDto.setReservationNumber(reservationEntity.getReservationNumber());
        reservationDto.setPayPrice(reservationEntity.getPayPrice());
        reservationDto.setIsBreakfast(reservationEntity.getIsBreakfast());
        reservationDto.setEnabled(reservationEntity.getEnabled());
        reservationDto.setRoomId(roomId);
        reservationDto.setUserId(userId);
        return reservationDto;
    }

}