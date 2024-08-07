package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * packageName : com.example.hotelbooking.entity
 * fileName    : PayEntity
 * author      : jaejun
 * date        : 2024-08-06
 * description :
 * ===================================================
 * DATE             AUTHOR              NOTE
 * ---------------------------------------------------
 * 2024-08-06         jaejun
 */
@Getter
@Setter
@Entity
@Table(name = "hotel_pay")
public class PayEntity extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 결제 금액
    @Column(name = "pay_price", nullable = false)
    private Long payPrice;

    // 결제 날짜
    @Column(name = "pay_date", nullable = false)
    private LocalDateTime payDate;

    // 결제 수단
    @Column(name = "pay_way", nullable = false)
    private String payWay;
}
