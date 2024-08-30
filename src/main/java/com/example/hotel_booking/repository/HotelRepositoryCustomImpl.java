package com.example.hotel_booking.repository;

import com.example.hotel_booking.entity.HotelEntity;
import com.example.hotel_booking.entity.HotelFacilityEntity;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelRepositoryCustomImpl implements HotelRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Long> findHotelsByCriteria(List<Long> gradeList, List<Long> cityIdList, List<Long> facilityIdList) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<HotelEntity> root = query.from(HotelEntity.class);
        query.select(root.get("id"));

        List<Predicate> predicates = new ArrayList<>();

        if (gradeList != null && !gradeList.isEmpty()) {
            predicates.add(root.get("hotelGrade").in(gradeList));
        }

        if (cityIdList != null && !cityIdList.isEmpty()) {
            predicates.add(root.get("cityEntity").get("id").in(cityIdList));
        }

        if (facilityIdList != null && !facilityIdList.isEmpty()) {
            Root<HotelFacilityEntity> hotelFacilityRoot = query.from(HotelFacilityEntity.class);
            predicates.add(hotelFacilityRoot.get("facilityId").in(facilityIdList));
            predicates.add(cb.equal(hotelFacilityRoot.get("hotelEntity"), root));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
