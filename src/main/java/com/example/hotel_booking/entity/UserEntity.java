package com.example.hotel_booking.entity;

import com.example.hotel_booking.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * packageName : com.example.hotel_booking.entity
 * fileName    : UserEntity
 * author      : jaejun
 * date        : 2024-08-07
 * description :
 * ===================================================
 * DATE             AUTHOR              NOTE
 * ---------------------------------------------------
 * 2024-08-07         jaejun
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 고객 이메일
    @Column(name = "email", columnDefinition = "varchar(100) not null comment '이메일'", nullable = false)
    private String email;

    // 고객 비밀번호
    @Column(name = "password")
    private String password;

    // 고객 이름
    @Column(name = "name")
    private String name;

    // 고객 닉네임
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "role")
    private String role;

    // 고객 주소
    @Column(name = "address")
    private String address;

    // 고객 성별
    @Column(name = "user_gender")
    private String userGender;

    // 고객 연락처
    @Column(name = "phone")
    private String phone;

    // 고객 등급
    @Column(name = "user_grade")
    private int userGrade;

    @Column(name = "user_total_amount")
    private Long userTotalAmount;

    @Column(name = "enabled")
    private int enabled;

    @Column(name = "visitor_count")
    private Long visitorCount;

    @CreatedDate
    private LocalDateTime createdTime;

    @OneToMany(mappedBy = "businessEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HotelEntity> hotels;

    public static UserEntity toGuestEntity(UserDto guestDto) {
        UserEntity guestEntity = new UserEntity();
        guestEntity.setId(guestDto.getId());
        guestEntity.setEmail(guestDto.getEmail());
        guestEntity.setPassword(guestDto.getPassword());
        guestEntity.setName(guestDto.getName());
        guestEntity.setNickname(guestDto.getNickname());
        guestEntity.setRole(guestDto.getRole());
        guestEntity.setAddress(guestDto.getAddress());
        guestEntity.setUserGender(guestDto.getUserGender());
        guestEntity.setPhone(guestDto.getPhone());
        guestEntity.setUserGrade(guestDto.getUserGrade());
        guestEntity.setUserTotalAmount(guestDto.getUserTotalAmount());
        guestEntity.setEnabled(guestDto.getEnabled());
        guestEntity.setVisitorCount(guestDto.getVisitorCount());
        return guestEntity;
    }

    public static UserEntity toUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setName(userDto.getName());
        userEntity.setNickname(userDto.getNickname());
        userEntity.setRole(userDto.getRole());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setUserGender(userDto.getUserGender());
        userEntity.setPhone(userDto.getPhone());
        userEntity.setUserGrade(userDto.getUserGrade());
        userEntity.setUserTotalAmount(userDto.getUserTotalAmount());
        userEntity.setEnabled(userDto.getEnabled());
        userEntity.setVisitorCount(userDto.getVisitorCount());

        return userEntity;
    }
}
