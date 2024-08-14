package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.UserDto;
import com.example.hotel_booking.entity.UserEntity;
import com.example.hotel_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDto findById(Long id) {
        Optional<UserEntity> guestEntityOptional = userRepository.findById(id);
        if (guestEntityOptional.isPresent()) {
            UserEntity guestEntity = guestEntityOptional.get();
            UserDto guestDto = UserDto.toGuestDto(guestEntity);
            return guestDto;
        } else {
            return null;
        }
    }

    public UserDto update(UserDto guestDto) {
        userRepository.save(UserEntity.toGuestEntity(guestDto));

        return findById(guestDto.getId());
    }

    public Optional<UserEntity> findByEmailAndNameAndPhone(String email, String name, String phone) {
        return userRepository.findByEmailAndNameAndPhone(email, name, phone);
    }

    public String getPassword(UserEntity user) {
        // 나중에 수정해야해 이건 테스트용
        return user.getPassword();
    }

    public Optional<UserEntity> findByNameAndPhone(String name, String phone) {
        return userRepository.findByNameAndPhone(name, phone);
    }
}
