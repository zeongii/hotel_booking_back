package com.example.hotel_booking.service;

import com.example.hotel_booking.entity.UserEntity;
import com.example.hotel_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public Optional<UserEntity> findByEmailAndNameAndPhone(String email, String name, String phone) {
        return userRepository.findByEmailAndNameAndPhone(email, name, phone);
    }

    public String getPassword(UserEntity user) {
        // 나중에 수정해야해
        return user.getPassword();
    }

    public Optional<UserEntity> findByNameAndPhone(String name, String phone) {
        return userRepository.findByNameAndPhone(name, phone);
    }


}

