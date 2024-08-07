package com.example.hotel_booking.entity;

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

    @Column(name = "infinity_pool", nullable = false)
    private Long infinityPool;

    @Column(name = "indoor_pool", nullable = false)
    private Long indoorPool;

    @Column(name = "sauna", nullable = false)
    private Long sauna;

    @Column(name = "kids_room", nullable = false)
    private Long kidsRoom;

    @Column(name = "casino", nullable = false)
    private Long casino;

    @Column(name = "fitness_center", nullable = false)
    private Long fitnessCenter;

    @Column(name = "free_wifi", nullable = false)
    private Long freeWifi;

    @Column(name = "laundry_room", nullable = false)
    private Long laundryRoom;

    @Column(name = "front_desk", nullable = false)
    private Long frontDesk;

    @Column(name = "restaurant", nullable = false)
    private Long restaurant;

    @Column(name = "free_parking", nullable = false)
    private Long freeParking;

    @Column(name = "bar", nullable = false)
    private Long bar;

    @Column(name = "atm", nullable = false)
    private Long atm;

    @Column(name = "outdoor_garden", nullable = false)
    private Long outdoorGarden;
}
