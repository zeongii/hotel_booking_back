package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.UserEntity;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.hotel_booking.entity.UserEntity}
 */
@Data
public class UserDto implements Serializable {
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
}