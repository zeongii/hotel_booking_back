package com.example.hotel_booking.dto;

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
}