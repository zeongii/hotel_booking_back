package com.example.hotel_booking.entity;

import com.example.hotel_booking.dto.HotelDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.example.hotelbooking.entity
 * fileName    : CoInfoEntity
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
@Table(name = "hotel")
public class HotelEntity extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 호텔 이름
    @Column(name = "hotel_name", nullable = false)
    private String hotelName;

    // 호텔 주소
    @Column(name = "hotel_address", nullable = false)
    private String hotelAddress;

    // 호텔 전화번호
    @Column(name = "hotel_phone", nullable = false)
    private String hotelPhone;

    // 호텔 이메일
    @Column(name = "hotel_email", nullable = false)
    private String hotelEmail;

    // 호텔 등급
    @Column(name = "hotel_grade", nullable = false)
    private Long hotelGrade;

    // 호텔 시설
    // 도시 정보 (외래키)
    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    // 사업 정보 (외래키)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity businessEntity;

    @OneToMany(mappedBy = "hotelEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelFacilityEntity> hotelFacilityEntities;

    @OneToMany(mappedBy = "hotelEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomEntity> roomEntities;

    @OneToMany(mappedBy = "hotelEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<HotelFileEntity> hotelFileEntityList = new ArrayList<>();


    public static HotelEntity toHotelEntity(HotelDto hotelDto, CityEntity cityEntity){
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setId(hotelDto.getId());
        hotelEntity.setHotelName(hotelDto.getHotelName());
        hotelEntity.setHotelAddress(hotelDto.getHotelAddress());
        hotelEntity.setHotelPhone(hotelDto.getHotelPhone());
        hotelEntity.setHotelEmail(hotelDto.getHotelEmail());
        hotelEntity.setHotelGrade(hotelDto.getHotelGrade());
        hotelEntity.setCityEntity(cityEntity);

        return hotelEntity;
    }

    public static HotelEntity updateHotelEntity(HotelDto hotelDto, CityEntity cityEntity){
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setId(hotelDto.getId());
        hotelEntity.setHotelName(hotelDto.getHotelName());
        hotelEntity.setHotelAddress(hotelDto.getHotelAddress());
        hotelEntity.setHotelPhone(hotelDto.getHotelPhone());
        hotelEntity.setHotelEmail(hotelDto.getHotelEmail());
        hotelEntity.setHotelGrade(hotelDto.getHotelGrade());
        hotelEntity.setCityEntity(cityEntity);


        return hotelEntity;
    }

    @Override
    public String toString() {
        return "HotelEntity{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelPhone='" + hotelPhone + '\'' +
                ", hotelEmail='" + hotelEmail + '\'' +
                ", hotelGrade=" + hotelGrade +
                ", cityId=" + cityEntity.getId() +
                ", businessEntity=" + businessEntity +
                ", hotelFileEntityList=" + hotelFileEntityList +
                '}';
    }
}