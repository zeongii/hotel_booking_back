package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.UserDto;
import com.example.hotel_booking.entity.UserEntity;
import com.example.hotel_booking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto selectByEmail(String Email) {
        Optional<UserEntity> byUserEmail = userRepository.findByEmail(Email);
        UserDto userDto= UserDto.toUserDto(byUserEmail.get());
        if(!byUserEmail.isPresent()){
            return null;
        } else{
            return userDto;
        }
    }

    public void register(UserDto userDto) {
        UserEntity userEntity= UserEntity.toUserEntity(userDto);
        userRepository.save(userEntity);
    }


}
