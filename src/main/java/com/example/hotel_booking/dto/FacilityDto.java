package com.example.hotel_booking.dto;

import lombok.Value;

import java.io.Serializable;

/*
 * DTO for {@link com.example.hotel_booking.entity.FacilityEntity}
 */
@Value
public class FacilityDto implements Serializable {
    Long id;
    Long infinityPool;
    Long indoorPool;
    Long sauna;
    Long kidsRoom;
    Long casino;
    Long fitnessCenter;
    Long freeWifi;
    Long laundryRoom;
    Long frontDesk;
    Long restaurant;
    Long freeParking;
    Long bar;
    Long atm;
    Long outdoorGarden;

}