package com.example.hotel_booking.entity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;

    public static HotelFileEntity toHotelFileEntity(HotelEntity hotelEntity, String originalFileName, String storedFileName){
        HotelFileEntity hotelFileEntity = new HotelFileEntity();
        hotelFileEntity.setOriginalFileName(originalFileName);
        hotelFileEntity.setStoredFileName(storedFileName);
        hotelFileEntity.setHotelEntity(hotelEntity);

        return hotelFileEntity;
    }
}
