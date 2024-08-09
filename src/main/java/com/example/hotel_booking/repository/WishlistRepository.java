package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.WishlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishlistRepository extends JpaRepository<WishlistEntity, Long> {
    @Query(value = "SELECT * FROM hotel_wishlist WHERE user_id = ?1", nativeQuery = true)
    List<WishlistEntity> findAllByGuestId(Long userId);

    @Query(value = "SELECT * FROM hotel_wishlist WHERE user_id = ?1 AND hotel_id = ?2", nativeQuery = true)
    WishlistEntity isExist(Long guestId, Long hotelId);
}

// SELECT infinipoll, wifi, .... FROM category ...