package com.example.hotel_booking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasswordCheckRequest {
    private Long userId;
    private String password;

}
