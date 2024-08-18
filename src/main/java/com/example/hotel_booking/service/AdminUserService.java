package com.example.hotel_booking.service;

import com.example.hotel_booking.entity.UserEntity;
import com.example.hotel_booking.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.hotel_booking.service
 * fileName    : AdminUserController
 * author      : jaejun
 * date        : 2024-08-13
 * description :
 * ===================================================
 * DATE             AUTHOR              NOTE
 * ---------------------------------------------------
 * 2024-08-13         jaejun
 */
@Service
@RequiredArgsConstructor
public class AdminUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


//    public UserEntity registerUser(UserDto userDto) {
//        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
//            throw new RuntimeException("email is already taken");
//        }
//
//
//
//        UserEntity user = UserEntity.builder()
//                .email(userDto.getEmail())
//                .password(passwordEncoder.encode(userDto.getPassword()))
//                .nickname(userDto.getNickname())
//                .role("ROLE_USER") // Default role
//                .address(userDto.getAddress())
//                .userGender(userDto.getUserGender())
//                .phone(userDto.getPhone())
//                .userGrade(userDto.getUserGrade())
//                .userTotalAmount(userDto.getUserTotalAmount())
//                .enabled(1)
//                .build();
//
//        return userRepository.save(user);
//        }


    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + email));
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));

    }
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    public Long incrementVisitorCount(Long userId) {
        // 현재 사용자의 방문 횟수를 조회
        Long currentVisitorCount = userRepository.findVisitorCountByUserId(userId);
        if (currentVisitorCount == null) {
            currentVisitorCount = 0L;
        }
        // 방문 횟수를 1 증가시킴
        Long updatedVisitorCount = currentVisitorCount + 1;
        userRepository.updateVisitorCount(updatedVisitorCount, userId);
        return updatedVisitorCount;
    }

    public int countUsers(List<String> roles) {
        return userRepository.countUsersByRoles(roles);
    }

}