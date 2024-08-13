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

        @Column(name = "facility_name")
        private String facilityName;
}

