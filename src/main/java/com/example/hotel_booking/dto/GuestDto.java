package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.GuestEntity;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

/*
 * DTO for {@link com.example.hotel_booking.entity.GuestEntity}
 */
//@Value
@Data
public class GuestDto implements Serializable {
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    String guestEmail;
    String guestPass;
    String guestName;
    String guestGender;
    String guestPhone;
    int guestGrade;
    Long guestTotalAmount;

    public static GuestDto toGuestDto(GuestEntity guestEntity) {
        GuestDto guestDto = new GuestDto();
        guestDto.setId(guestEntity.getId());
        guestDto.setGuestEmail(guestEntity.getGuestEmail());
        guestDto.setGuestPass(guestEntity.getGuestPass());
        guestDto.setGuestName(guestEntity.getGuestName());
        guestDto.setGuestGender(guestEntity.getGuestGender());
        guestDto.setGuestPhone(guestEntity.getGuestPhone());
        guestDto.setGuestGrade(guestEntity.getGuestGrade());
        guestDto.setGuestTotalAmount(guestEntity.getGuestTotalAmount());
        return guestDto;
    }
}