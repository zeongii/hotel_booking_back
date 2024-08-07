package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName : com.example.hotelbooking.entity
 * fileName    : InfoEntity
 * author      : jaejun
 * date        : 2024-08-06
 * description : 예약정보
 * ===================================================
 * DATE             AUTHOR              NOTE
 * ---------------------------------------------------
 * 2024-08-06         jaejun
 */

@Getter
@Setter
@Entity
@Table(name = "room_type")
public class RoomTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name", nullable = false)
    private String typeName;

    @Column(name = "type_content", nullable = false)
    private String typeContent;
}
