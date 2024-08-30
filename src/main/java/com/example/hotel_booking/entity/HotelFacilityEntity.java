package com.example.hotel_booking.entity;

import com.example.hotel_booking.dto.FacilityDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hotel_facility")
public class HotelFacilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "facility_id")
    private Long facilityId;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private HotelEntity hotelEntity;

    public static HotelFacilityEntity toFacilityEntity(FacilityDto facilityDto, HotelEntity hotelEntity){
        HotelFacilityEntity facilityEntity = new HotelFacilityEntity();
        facilityEntity.setFacilityId(facilityDto.getFacilityId());
        facilityEntity.setHotelEntity(hotelEntity);
        return facilityEntity;
    }

    public static HotelFacilityEntity toUpdateFacilityEntity(FacilityDto facilityDto, HotelEntity hotelEntity){
        HotelFacilityEntity facilityEntity = new HotelFacilityEntity();
        facilityEntity.setId(facilityDto.getId());
        facilityEntity.setFacilityId(facilityDto.getFacilityId());
        facilityEntity.setHotelEntity(hotelEntity);
        return facilityEntity;
    }

    public static HotelFacilityEntity toHotelFacilityEntity(FacilityDto facilityDto,HotelEntity hotelEntity) {
        HotelFacilityEntity hotelFacilityEntity = new HotelFacilityEntity();
        hotelFacilityEntity.setId(facilityDto.getId());
        hotelFacilityEntity.setFacilityId(facilityDto.getFacilityId());
        hotelFacilityEntity.setHotelEntity(hotelEntity);
        return hotelFacilityEntity;
    }

        /*public static FacilityEntity toFacilityEntity(FacilityDto facilityDto){
                FacilityEntity facilityEntity = new FacilityEntity();
                facilityEntity.setId(facilityDto.getId());
                facilityEntity.setFacilityId(facilityDto.getFacilityId());
                return facilityEntity;
        }*/




}