package com.example.hotel_booking.dto;


import com.example.hotel_booking.entity.RoomFileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomFileDto {
    private Long id;
    private String originalFileName;
    private String storedFileName;
    private String extension;
    private Long roomId;

    public  static RoomFileDto toRoomFileDto(RoomFileEntity roomFileEntity, Long roomId) {
        RoomFileDto roomFileDto=new RoomFileDto();
        roomFileDto.setId(roomFileEntity.getId());
        roomFileDto.setOriginalFileName(roomFileEntity.getOriginalFileName());
        roomFileDto.setStoredFileName(roomFileEntity.getStoredFileName());
        roomFileDto.setRoomId(roomId);

        return roomFileDto;
    }
}
