package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.ReviewDto;
import com.example.hotel_booking.entity.ReviewEntity;
import com.example.hotel_booking.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    //user id로 리뷰 모두 가져오기
    public List<ReviewDto> findAllByGuestId(Long id) {
        List<ReviewEntity> reviewEntityOptional = reviewRepository.findAllByGuestId(id);
        List<ReviewDto> reviewDtoList = new ArrayList<>();

        for (ReviewEntity reviewEntity : reviewEntityOptional) {
            ReviewDto reviewDto = ReviewDto.toReviewDto(reviewEntity);
            reviewDtoList.add(reviewDto);
        }

        return reviewDtoList;
    }

    public void reviewAdd(ReviewDto reviewDto) {
        ReviewEntity reviewEntity = ReviewEntity.toAddReviewEntity(reviewDto);
        reviewRepository.save(reviewEntity);
    }

    public ReviewDto findById(Long id) {
        ReviewEntity reviewEntity = reviewRepository.findById(id).orElse(null);
        return reviewEntity != null ? ReviewDto.toReviewDto(reviewEntity) : null;
    }

    public void reviewUpdate(ReviewDto reviewDto) {
        ReviewEntity reviewEntity = ReviewEntity.toUpdateReviewEntity(reviewDto);
        reviewRepository.save(reviewEntity);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
