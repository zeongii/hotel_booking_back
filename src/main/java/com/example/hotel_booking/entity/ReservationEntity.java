package com.example.hotel_booking.entity;

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

    // 예약 활성화 여부 (1: 활성화, 0: 취소)
    @Column(name = "enabled", nullable = false)
    private int enabled;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;

    @ManyToOne
    @JoinColumn(name="guest_id")
    private GuestEntity guestEntity;

}
