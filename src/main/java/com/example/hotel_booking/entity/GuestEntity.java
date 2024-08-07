package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_guest")
public class GuestEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 고객 이메일
    @Column(name = "guest_email", columnDefinition = "varchar(100) not null comment '이메일'", nullable = false)
    private String guestEmail;

    // 고객 비밀번호
    @Column(name = "guest_pass", nullable = false)
    private String guestPass;

    // 고객 이름
    @Column(name = "guest_name", nullable = false)
    private String guestName;

    // 고객 성별
    @Column(name = "guest_gender", nullable = false)
    private String guestGender;

    // 고객 연락처
    @Column(name = "guest_phone", nullable = false)
    private String guestPhone;

    // 고객 등급
    @Column(name = "guest_grade", nullable = false)
    private int guestGrade;

    // 고객 총 지출 금액
    @Column(name = "guest_total_amount", nullable = false)
    private Long guestTotalAmount;
}




    // FK 제약조건

