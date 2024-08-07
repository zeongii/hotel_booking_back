package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * packageName : com.example.hotelbooking.entity
 * fileName    : Mon_SalesEntity
 * author      : jaejun
 * date        : 2024-08-06
 * description : 월, 일별 매출 합쳤으면 함
 * ===================================================
 * DATE             AUTHOR              NOTE
 * ---------------------------------------------------
 * 2024-08-06         jaejun
 */
@Getter
@Setter
@Entity
@Table(name = "hotel_sales")
public class SalesEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sales_date", nullable = false)
    private LocalDateTime salesDate;

}
