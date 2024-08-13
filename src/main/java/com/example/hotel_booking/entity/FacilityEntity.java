package com.example.hotel_booking.entity;

import com.example.hotel_booking.dto.FacilityDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "facility")
public class FacilityEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "facility_id")
        private Long facilityId;

        @ManyToOne
        @JoinColumn(name="hotel_id")
        private HotelEntity HotelEntity;

        public static FacilityEntity toFacilityEntity(FacilityDto facilityDto, HotelEntity hotelEntity){
                FacilityEntity facilityEntity = new FacilityEntity();
                facilityEntity.setId(facilityDto.getId());
                facilityEntity.setFacilityId(facilityDto.getFacilityId());
                facilityEntity.setHotelEntity(hotelEntity);
                return facilityEntity;
        }

        /*public static FacilityEntity toFacilityEntity(FacilityDto facilityDto){
                FacilityEntity facilityEntity = new FacilityEntity();
                facilityEntity.setId(facilityDto.getId());
                facilityEntity.setFacilityId(facilityDto.getFacilityId());
                return facilityEntity;
        }*/





}
