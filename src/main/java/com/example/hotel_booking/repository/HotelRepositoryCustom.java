package com.example.hotel_booking.repository;

import java.util.List;

public interface HotelRepositoryCustom {
    List<Long> findHotelsByCriteria(List<Long> gradeList, List<Long> cityIdList, List<Long> facilityIdList);
}
