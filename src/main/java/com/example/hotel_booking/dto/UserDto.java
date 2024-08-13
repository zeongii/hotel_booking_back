package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.UserEntity;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * DTO for {@link com.example.hotel_booking.entity.UserEntity}
 */
@Data
public class UserDto implements Serializable {
    private UserEntity user;
    Long id;
    String email;
    String password;
    String name;
    String nickname;
    String role;
    String address;
    String userGender;
    String phone;
    int userGrade;
    Long userTotalAmount;
    int enabled;

    public static UserDto toGuestDto(UserEntity guestEntity) {
        UserDto guestDto = new UserDto();
        guestDto.setId(guestEntity.getId());
        guestDto.setEmail(guestEntity.getEmail());
        guestDto.setPassword(guestEntity.getPassword());
        guestDto.setName(guestEntity.getName());
        guestDto.setNickname(guestEntity.getNickname());
        guestDto.setRole(guestEntity.getRole());
        guestDto.setAddress(guestEntity.getAddress());
        guestDto.setUserGender(guestEntity.getUserGender());
        guestDto.setPhone(guestEntity.getPhone());
        guestDto.setUserGrade(guestEntity.getUserGrade());
        guestDto.setUserTotalAmount(guestEntity.getUserTotalAmount());
        guestDto.setEnabled(guestEntity.getEnabled());
        return guestDto;
    }

    public static UserDto toUserDto(UserEntity userEntity) {
        UserDto userDto= new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setName(userEntity.getName());
        userDto.setNickname(userEntity.getNickname());
        userDto.setRole(userEntity.getRole());
        userDto.setAddress(userEntity.getAddress());
        userDto.setUserGender(userEntity.getUserGender());
        userDto.setPhone(userEntity.getPhone());
        userDto.setUserGrade(userEntity.getUserGrade());
        userDto.setUserTotalAmount(userEntity.getUserTotalAmount());
        userDto.setEnabled(userEntity.getEnabled());

        return userDto;
    }

}