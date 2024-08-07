package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_business")
public class BusinessEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 업체이메일
    @Column(name = "business_email", columnDefinition = "varchar(45) not null comment '업체 이메일'", nullable = false)
    private String businessEmail;

    // 업체비밀번호
    @Column(name = "business_password", nullable = false)
    private String businessPassword;

    // 업체이름
    @Column(name = "company_name", nullable = false)
    private String companyName;

    //업체연락처
    @Column(name = "company_phone", nullable = false)
    private String companyPhone;

    @Column(name = "company_address", nullable = false)
    private String companyAddress;

    @Column(name = "enabled", nullable = false)
    private int enabled;

}



    // FK 제약조건

