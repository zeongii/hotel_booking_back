package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 * packageName : com.example.hotelbooking.entity
 * fileName    : WishlistEntity
 * author      : jaejun
 * date        : 2024-08-06
 * description :
 * ===================================================
 * DATE             AUTHOR              NOTE
 * ---------------------------------------------------
 * 2024-08-06         jaejun
 */@Getter
@Setter
@Entity
@Table(name = "hotel_wishlist")
public class WishlistEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private HotelEntity hotelEntity;

    @ManyToOne
    @JoinColumn(name = "quest_id")
    private GuestEntity guestEntity;
}

