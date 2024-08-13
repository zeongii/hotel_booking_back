package com.example.hotel_booking.entity;

import com.example.hotel_booking.dto.ReservationDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "room_reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 예약 시작 날짜
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    // 예약 종료 날짜
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    // 예약 번호
    @Column(name = "reservation_number", nullable = false)
    private String reservationNumber;

    // 결제 금액
    @Column(name = "pay_price", nullable = false)
    private double payPrice;

    // 아침식사 포함 여부 (1: 포함, 0: 미포함)
    @Column(name = "is_breakfast", nullable = false)
    private Long isBreakfast;

    // 예약 활성화 여부 (0:예약 취소, 1: 예약, 2: 결제, 3: 이용은 o 리뷰는 x, 4, 리뷰까지 다 함)
    @Column(name = "enabled", nullable = false)
    private int enabled;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity guestEntity;

    public static ReservationEntity toInsertEntity(ReservationDto reservationDto, UserEntity userEntity, RoomEntity roomEntity) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setStartDate(reservationDto.getStartDate());
        reservationEntity.setEndDate(reservationDto.getEndDate());
        reservationEntity.setReservationNumber(reservationDto.getReservationNumber());
        reservationEntity.setPayPrice(reservationDto.getPayPrice());
        reservationEntity.setIsBreakfast(reservationDto.getIsBreakfast());
        reservationEntity.setEnabled(reservationDto.getEnabled());
        reservationEntity.setRoomEntity(roomEntity);
        reservationEntity.setGuestEntity(userEntity);

        return reservationEntity;
    }

    public static ReservationEntity toUpdateEntity(ReservationDto reservationDto, UserEntity userEntity, RoomEntity roomEntity) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setId(reservationDto.getId());
        reservationEntity.setStartDate(reservationDto.getStartDate());
        reservationEntity.setEndDate(reservationDto.getEndDate());
        reservationEntity.setReservationNumber(reservationDto.getReservationNumber());
        reservationEntity.setPayPrice(reservationDto.getPayPrice());
        reservationEntity.setIsBreakfast(reservationDto.getIsBreakfast());
        reservationEntity.setEnabled(reservationDto.getEnabled());
        reservationEntity.setRoomEntity(roomEntity);
        reservationEntity.setGuestEntity(userEntity);

        return reservationEntity;
    }


}
