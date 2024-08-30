package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.*;
import com.example.hotel_booking.entity.ReviewEntity;
import com.example.hotel_booking.entity.UserEntity;
import com.example.hotel_booking.service.ReservationService;
import com.example.hotel_booking.service.ReviewService;
import com.example.hotel_booking.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/guest/")
public class GuestController {
    private final WishlistService wishlistService;
    private final ReviewService reviewService;

    //리뷰 등록
    @GetMapping("review/{id}")
    public ResponseEntity<List<?>> review(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.findAllByGuestId(id));
    }

    //리뷰 수정 페이지로 갈 때 리뷰 정보 가져오기
    @GetMapping("review")
    public ResponseEntity<ReviewEntity> reviewPage() {
        ReviewEntity reviewEntity = new ReviewEntity();
        return ResponseEntity.ok(reviewEntity);
    }

    // 리뷰 추가 API
    @PostMapping("review")
    public void reviewAdd(@RequestBody ReviewDto reviewDto) {
        reviewDto.setTotalRating(reviewDto.setTotalRating());
        reviewService.reviewAdd(reviewDto);
    }

    //리뷰 수정 페이지로
    @GetMapping("review/update/{id}")
    public ResponseEntity<ReviewEntity> updatePage(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.findById(id));
    }

    //리뷰 업데이트 API
    @PutMapping("review/update")
    public void reviewUpdate(@RequestBody ReviewDto reviewDto) {
        reviewDto.setTotalRating(reviewDto.setTotalRating());
        reviewService.reviewUpdate(reviewDto);
    }

    //리뷰 삭제 API
    @DeleteMapping("review/{id}")
    public void reviewDelete(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    // 좋아하는 호텔 유저 id를 통해 가져오기(내 찜 목록)
    @GetMapping("wishlist/{id}")
    public ResponseEntity<List<?>> wishlist(@PathVariable Long id) {
        return ResponseEntity.ok(wishlistService.findAllByGuestId(id));
    }

    // 좋아하는 호텔 저장
    @PostMapping("wishlist")
    public ResponseEntity<String> wishAddDelete(@RequestBody WishlistDto wishlistDto) {
        wishlistService.wishAddDelete(wishlistDto);

        return ResponseEntity.ok().build();
    }

}
