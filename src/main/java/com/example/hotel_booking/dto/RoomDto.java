package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.RoomEntity;
import com.example.hotel_booking.entity.RoomFileEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link com.example.hotel_booking.entity.RoomEntity}
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto implements Serializable {
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Long id;
    private String roomName;
    private Long roomMax;
    private Long roomPrice;
    private String roomContent;
    private Long hotelId;
    private Long roomTypeId;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Long breakfastPrice;

    private List<MultipartFile> File;
    private List<String> originalFileName;
    private List<String> storedFileName; // 서버 저장용 파일 이름
    private Integer fileAttached;

    public static RoomDto toRoomDto(RoomEntity roomEntity, Long hotelId) {
        RoomDto roomDto=new RoomDto();
        roomDto.setId(roomEntity.getId());
        roomDto.setRoomName(roomEntity.getRoomName());
        roomDto.setRoomMax(roomEntity.getRoomMax());
        roomDto.setRoomPrice(roomEntity.getRoomPrice());
        roomDto.setRoomContent(roomEntity.getRoomContent());
        roomDto.setHotelId(hotelId);
        roomDto.setRoomTypeId(roomEntity.getRoomTypeEntity().getId());
        roomDto.setCheckIn(roomEntity.getCheckIn());
        roomDto.setCheckOut(roomEntity.getCheckOut());
        roomDto.setCreatedTime(roomEntity.getCreatedTime());
        roomDto.setUpdatedTime(roomEntity.getUpdatedTime());
        roomDto.setBreakfastPrice(roomEntity.getBreakfastPrice());
        if (roomEntity.getFileAttached() ==null) {
             roomDto.setFileAttached(roomDto.getFileAttached());
        } else {
            List<String> originalFileNameList = new ArrayList<>();
            List <String> storedFileNameList = new ArrayList<>();
            roomDto.setFileAttached(roomEntity.getFileAttached());
            //파일 이름도 가져가야함
            // originalFileName, storedFileName : board_file_table(boardFileEntity)]
            for (RoomFileEntity roomFileEntity: roomEntity.getRoomFileEntityList()) {
                originalFileNameList.add(roomFileEntity.getOriginalFileName());
                storedFileNameList.add(roomFileEntity.getStoredFileName());
            }
            /*boardDTO.setOriginalFileName(boardEntity.getBoardFileEntityList().get(0).getOriginalFileName());
            boardDTO.setStoredFileName(boardEntity.getBoardFileEntityList().get(0).getStoredFileName());*/
            roomDto.setOriginalFileName(originalFileNameList);
            roomDto.setStoredFileName(storedFileNameList);
        }
        return roomDto;
    }
}