package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.UserEntity;
import lombok.Data;

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

    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String role;
    private String address;
    private String userGender;
    private String phone;
    private int userGrade;
    private Long userTotalAmount;
    private int enabled;




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