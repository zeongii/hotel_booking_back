package com.example.hotel_booking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "room_file_table")
public class RoomFileEntity extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    //자식 테이블의 정의
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id")
    private RoomEntity roomEntity;

    public static RoomFileEntity toRoomFileEntity(RoomEntity roomEntity, String originalFileName, String storedFileName) {
        RoomFileEntity roomFileEntity = new RoomFileEntity();
        roomFileEntity.setOriginalFileName(originalFileName);
        roomFileEntity.setStoredFileName(storedFileName);
        roomFileEntity.setRoomEntity(roomEntity);
        return roomFileEntity;
    }
}
