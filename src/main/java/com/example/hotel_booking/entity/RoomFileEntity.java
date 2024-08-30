package com.example.hotel_booking.entity;

import com.example.hotel_booking.dto.RoomFileDto;
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

    @Column
    private String extension;

    //자식 테이블의 정의
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id")
    private RoomEntity roomEntity;

    public static RoomFileEntity toRoomFileEntity(RoomFileDto roomFileDto, RoomEntity roomEntity) {
        RoomFileEntity roomFileEntity = new RoomFileEntity();
        roomFileEntity.setOriginalFileName(roomFileDto.getOriginalFileName());
        roomFileEntity.setStoredFileName(roomFileDto.getStoredFileName());
        roomFileEntity.setExtension(roomFileEntity.extension);
        roomFileEntity.setRoomEntity(roomEntity);
        return roomFileEntity;
    }
}
