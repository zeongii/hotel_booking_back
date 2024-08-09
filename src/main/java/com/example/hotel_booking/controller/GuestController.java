package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.ReservationDto;
import com.example.hotel_booking.dto.ReviewDto;
import com.example.hotel_booking.dto.UserDto;
import com.example.hotel_booking.dto.WishlistDto;
import com.example.hotel_booking.entity.UserEntity;
import com.example.hotel_booking.service.GuestService;
import com.example.hotel_booking.service.ReservationService;
import com.example.hotel_booking.service.ReviewService;
import com.example.hotel_booking.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/guest/")
public class GuestController {
    private final GuestService guestService;
    private final ReservationService reservationService;
    private final WishlistService wishlistService;
    private final ReviewService reviewService;

    //id로 유저 정보 가져오기(내 정보)
    @GetMapping("update/{id}")
    public UserDto update(@PathVariable Long id, Model model) {
        System.out.println("id = " + id + ", model = " + model);
        UserDto userDto = guestService.findById(id);
        model.addAttribute("guest", userDto);
        return userDto;
    }

    //유저 업데이트(수정 페이지로)
    @PostMapping("update")
    public UserDto update(@RequestBody UserDto guestDto, Model model) {
        UserDto updatedGuestDto = guestService.update(guestDto);
        model.addAttribute("guest", updatedGuestDto);
        return updatedGuestDto;
    }

    //예약 정보 출력(내 예약)
    @GetMapping("reservationInfo/{id}")
    public List<ReservationDto> reservationInfo(@PathVariable Long id) {
        List<ReservationDto> reservationDtoList = reservationService.findAllByGuestId(id);
        return reservationDtoList;
    }

    // 좋아하는 호텔 유저 id를 통해 가져오기(내 찜 목록)
    @GetMapping("wishlist/{id}")
    public List<WishlistDto> wishlist(@PathVariable Long id) {
        List<WishlistDto> WishlistList = wishlistService.findAllByGuestId(id);
        return WishlistList;
    }

    // 좋아하는 호텔 저장
    @PostMapping("wishlist")
    public String wishAddDelete(@RequestBody WishlistDto wishlistDto) {
        wishlistService.wishAddDelete(wishlistDto);

        return null;
    }

    //리뷰 등록
    @GetMapping("review/{id}")
    public List<ReviewDto> review(@PathVariable Long id) {
        List<ReviewDto> reviewDtoList = reviewService.findAllByGuestId(id);

        return reviewDtoList;
    }

    //리뷰 수정 페이지로 갈 때 리뷰 정보 가져오기
    @GetMapping("review")
    public ReviewDto reviewPage() {
        ReviewDto reviewDto = new ReviewDto();
        return reviewDto;
    }

    // 리뷰 추가 API
    @PostMapping("review")
    public void reviewAdd(@RequestBody ReviewDto reviewDto) {
        reviewDto.setTotalRating(reviewDto.setTotalRating());
        reviewService.reviewAdd(reviewDto);
    }

    //리뷰 수정 페이지로
    @GetMapping("review/update/{id}")
    public ReviewDto updatePage(@PathVariable Long id) {
        ReviewDto reviewDto = reviewService.findById(id);
        return reviewDto;
    }

    //리뷰 업데이트 API
    @PostMapping("review/update")
    public void reviewUpdate(@RequestBody ReviewDto reviewDto) {
        reviewDto.setTotalRating(reviewDto.setTotalRating());
        reviewService.reviewUpdate(reviewDto);
    }

    //리뷰 삭제 API
    @GetMapping("review/delete/{id}")
    public void reviewDelete(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    //이메일 찾기
    @PostMapping("forgot-username")
    public ResponseEntity<Map<String, Object>> forgotUsername(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String phone = request.get("phone");
        Map<String, Object> resultMap = new HashMap<>();

        try {
            Optional<UserEntity> userOptional = guestService.findByNameAndPhone(name, phone);
            if (userOptional.isPresent()) {
                UserEntity user = userOptional.get();
                resultMap.put("result", "success");
                resultMap.put("email", user.getEmail());
                return ResponseEntity.ok(resultMap);
            } else {
                resultMap.put("result", "fail");
                resultMap.put("message", "User not found");
                return ResponseEntity.status(404).body(resultMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", "fail");
            resultMap.put("message", e.getMessage());
            return ResponseEntity.status(500).body(resultMap);
        }
    }

    //비밀번호 찾기
    @PostMapping("forgot-password")
    public ResponseEntity<Map<String, Object>> forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String name = request.get("name");
        String phone = request.get("phone");
        Map<String, Object> resultMap = new HashMap<>();

        try {
            Optional<UserEntity> userOptional = guestService.findByEmailAndNameAndPhone(email, name, phone);
            if (userOptional.isPresent()) {
                UserEntity user = userOptional.get();
                if (user.getName().equals(name) && user.getPhone().equals(phone)) {
                    String password = guestService.getPassword(user); // 비밀번호 반환
                    resultMap.put("result", "success");
                    resultMap.put("password", password); // 주의: 해시된 비밀번호가 반환됩니다.
                    return ResponseEntity.ok(resultMap);
                } else {
                    resultMap.put("result", "fail");
                    resultMap.put("message", "일치하는 정보가 없습니다.");
                    return ResponseEntity.status(404).body(resultMap);
                }
            } else {
                resultMap.put("result", "fail");
                resultMap.put("message", "찾기 실패");
                return ResponseEntity.status(404).body(resultMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", "fail");
            resultMap.put("message", e.getMessage());
            return ResponseEntity.status(500).body(resultMap);
        }


    }
}
