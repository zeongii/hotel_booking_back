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
    private final UserRepository userRepository;

    @Autowired
    public GuestService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
}
