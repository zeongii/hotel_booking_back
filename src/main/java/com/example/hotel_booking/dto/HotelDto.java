package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.entity.HotelFileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/*
 * DTO for {@link com.example.hotel_booking.entity.HotelEntity}
 */

@Getter
@Setter
@NoArgsConstructor
public class HotelDto implements Serializable {
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private Long id;
    private String hotelName;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelEmail;
    private Long hotelGrade;
    private Long cityId;

    private List<MultipartFile> hotelFile; // save.html -> controller 파일 담는 용도
    private List<String> originalFileName; // 원본 파일 이름
    private List<String> storedFileName; // 서버 저장용 파일 이름


    public static HotelDto toHotelDto(HotelEntity hotelEntity) {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setId(hotelEntity.getId());
        hotelDto.setHotelName(hotelEntity.getHotelName());
        hotelDto.setHotelAddress(hotelEntity.getHotelAddress());
        hotelDto.setHotelEmail(hotelEntity.getHotelEmail());
        hotelDto.setHotelPhone(hotelEntity.getHotelPhone());
        hotelDto.setHotelGrade(hotelEntity.getHotelGrade());


        return hotelDto;
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelPhone='" + hotelPhone + '\'' +
                ", hotelEmail='" + hotelEmail + '\'' +
                ", hotelGrade=" + hotelGrade +
                ", cityId=" + cityId +
                '}';
    }
}