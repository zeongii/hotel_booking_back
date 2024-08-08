package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.RoomTypeEntity;
import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.example.hotel_booking.entity.RoomTypeEntity}
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoomTypeDto implements Serializable {
    private Long id;
    private String typeName;
    private String typeContent;

    public static RoomTypeDto toRoomTypeDto(RoomTypeEntity roomTypeEntity) {
        RoomTypeDto roomTypeDto = new RoomTypeDto();
        roomTypeDto.setId(roomTypeEntity.getId());
        roomTypeDto.setTypeName(roomTypeEntity.getTypeName());
        roomTypeDto.setTypeContent(roomTypeEntity.getTypeContent());
        return roomTypeDto;
    }
}