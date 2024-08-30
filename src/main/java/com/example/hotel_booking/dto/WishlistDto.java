package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.WishlistEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/*
 * DTO for {@link com.example.hotel_booking.entity.WishlistEntity}
 */
//@Value
@Data
public class WishlistDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    Long hotelId;
    Long guestId;

    public static WishlistDto toWishlistDto(WishlistEntity wishlistEntity) {
        WishlistDto wishlistDto = new WishlistDto();
        wishlistDto.setId(wishlistEntity.getId());
        wishlistDto.setHotelId(wishlistEntity.getHotelId());
        wishlistDto.setGuestId(wishlistEntity.getUserId());
        return wishlistDto;
    }
}