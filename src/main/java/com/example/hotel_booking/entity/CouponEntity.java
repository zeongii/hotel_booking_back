package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName : com.example.hotelbooking.entity
 * fileName    : CouponEntity
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
@Table(name = "hotel_coupon")
public class CouponEntity extends TimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 쿠폰명
    @Column(name = "cou_name", nullable = false)
    private String couName;

    // 할인종류
    @Column(name = "cou_type", nullable = false)
    private String couType;

    // 할인값
    @Column(name = "cou_value", nullable = false)
    private Long couValue;

    // 사용유무
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
}
