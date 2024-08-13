package com.example.hotel_booking.entity;

import com.example.hotel_booking.dto.HotelFileDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "hotel_file_table")
public class HotelFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    @Column
    private String extension;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;

    public static HotelFileEntity toHotelFileEntity(HotelFileDto hotelFileDto, HotelEntity hotelEntity){
        HotelFileEntity hotelFileEntity = new HotelFileEntity();
        hotelFileEntity.setOriginalFileName(hotelFileDto.getOriginalFileName());
        hotelFileEntity.setStoredFileName(hotelFileDto.getStoredFileName());
        hotelFileEntity.setExtension(hotelFileDto.getExtension());
        hotelFileEntity.setHotelEntity(hotelEntity);

        return hotelFileEntity;
    }
}
