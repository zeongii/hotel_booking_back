package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName : com.example.hotelbooking.entity
 * fileName    : AdminEntity
 * author      : jaejun
 * date        : 2024-08-06
 * description :
 * ===================================================
 * DATE             AUTHOR              NOTE
 * ---------------------------------------------------
 * 2024-08-06         jaejun
 */
@Getter
@Setter
@Entity
@Table(name = "user_admin")
public class AdminEntity extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad_email", nullable = false, unique = true)
    private String adEmail;

    @Column(name = "ad_pass", nullable = false)
    private String adPass;

    @Column(name = "ad_name", nullable = false)
    private String adName;
    // 사용유무
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

}
