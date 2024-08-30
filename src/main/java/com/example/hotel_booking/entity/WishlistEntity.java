package com.example.hotel_booking.entity;

import com.example.hotel_booking.dto.WishlistDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

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
 */
@Getter
@Setter
@Entity
@Table(name = "hotel_wishlist")
public class WishlistEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "hotel_id")
//    private HotelEntity hotelEntity;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserEntity guestEntity;

    @JoinColumn(name = "hotel_id")
    private Long hotelId;

    @JoinColumn(name = "user_id")
    private Long userId;

//    public static WishlistDto toWishlistDto(WishlistEntity wishlistEntity) {
//        WishlistDto wishlistDto = new WishlistDto();
//        wishlistDto.setId(wishlistEntity.getId());
//        wishlistDto.setHotelId(wishlistEntity.getHotelId());
//        wishlistDto.setGuestId(wishlistEntity.getUserId());
//        return wishlistDto;
//    }

    public static WishlistEntity toWishlistEntity(WishlistDto wishlistDto) {
        WishlistEntity wishlistEntity = new WishlistEntity();
        wishlistEntity.setHotelId(wishlistDto.getHotelId());
        wishlistEntity.setUserId(wishlistDto.getGuestId());
        return wishlistEntity;
    }

    @Override
    public String toString() {
        return "WishlistEntity{" +
                "id=" + id +
                ", hotelId=" + hotelId +
                ", guestId=" + userId +
                '}';
    }
}

