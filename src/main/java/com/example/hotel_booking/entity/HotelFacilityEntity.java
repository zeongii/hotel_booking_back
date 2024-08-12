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

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "hotel_id")
        private HotelEntity hotelEntity;

        public static HotelFacilityEntity toFacilityEntity(FacilityDto facilityDto, HotelEntity hotelEntity){
                HotelFacilityEntity facilityEntity = new HotelFacilityEntity();
                facilityEntity.setId(facilityDto.getId());
                facilityEntity.setFacilityId(facilityDto.getFacilityId());
                facilityEntity.setHotelEntity(hotelEntity);
                return facilityEntity;
        }





}
