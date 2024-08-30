package com.example.hotel_booking.entity;

import com.example.hotel_booking.dto.RoomDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName : com.example.hotelbooking.entity
 * fileName    : InfoEntity
 * author      : jaejun
 * date        : 2024-08-06
 * description : 예약정보
 * ===================================================
 * DATE             AUTHOR              NOTE
 * ---------------------------------------------------
 * 2024-08-06         jaejun
 */

@Getter
@Setter
@Entity
@Table(name = "room")
public class RoomEntity extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 방 이름
    @Column(name = "room_name", nullable = false)
    private String roomName;

    // 룸 갯수
    @Column(name = "room_max", nullable = false)
    private Long roomMax;

    // 룸 가격
    @Column(name = "room_price", nullable = false)
    private Long roomPrice;

    // 방 설명
    @Column(name = "room_content", nullable = false)
    private String roomContent;

    @Column(name = "breakfast_price", nullable = false)
    private Long breakfastPrice;

    // 호텔이랑 (외래키) 자식
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity businessEntity;

    @OneToMany(mappedBy = "roomEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RoomFileEntity> roomFileEntityList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomTypeEntity roomTypeEntity;

    public static RoomEntity toInsertEntity(RoomDto roomDto, HotelEntity hotelEntity, RoomTypeEntity roomTypeEntity, UserEntity businessEntity) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setRoomName(roomDto.getRoomName());
        roomEntity.setRoomMax(roomDto.getRoomMax());
        roomEntity.setRoomPrice(roomDto.getRoomPrice());
        roomEntity.setRoomContent(roomDto.getRoomContent());
        /*roomEntity.setCheckIn(roomDto.getCheckIn());
        roomEntity.setCheckOut(roomDto.getCheckOut());*/
        roomEntity.setBreakfastPrice(roomDto.getBreakfastPrice());
        roomEntity.setHotelEntity(hotelEntity);
        roomEntity.setRoomTypeEntity(roomTypeEntity);
        roomEntity.setBusinessEntity(businessEntity);
        return roomEntity;
    }

    public static RoomEntity toUpdateEntity(RoomDto roomDto, HotelEntity hotelEntity,RoomTypeEntity roomTypeEntity, UserEntity businessEntity) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(roomDto.getId());
        roomEntity.setRoomName(roomDto.getRoomName());
        roomEntity.setRoomMax(roomDto.getRoomMax());
        roomEntity.setRoomPrice(roomDto.getRoomPrice());
        roomEntity.setRoomContent(roomDto.getRoomContent());
        /*roomEntity.setCheckIn(roomDto.getCheckIn());
        roomEntity.setCheckOut(roomDto.getCheckOut());*/
        roomEntity.setBreakfastPrice(roomDto.getBreakfastPrice());
        roomEntity.setHotelEntity(hotelEntity);
        roomEntity.setRoomTypeEntity(roomTypeEntity);
        roomEntity.setBusinessEntity(businessEntity);

        return roomEntity;
    }

    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {}
        return obj;
    }

}
