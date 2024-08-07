package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.GuestDto;
import com.example.hotel_booking.entity.GuestEntity;
import com.example.hotel_booking.repository.GuestEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GuestService {
    private final GuestEntityRepository guestEntityRepository;

    @Autowired
    public GuestService(GuestEntityRepository guestEntityRepository) {
        this.guestEntityRepository = guestEntityRepository;
    }

    public GuestDto findById(Long id) {
        Optional<GuestEntity> guestEntityOptional = guestEntityRepository.findById(id);
        if (guestEntityOptional.isPresent()) {
            GuestEntity guestEntity = guestEntityOptional.get();
            GuestDto guestDto = GuestDto.toGuestDto(guestEntity);
            return guestDto;
        } else {
            return null;
        }
    }

    public GuestDto update(GuestDto guestDto) {
        GuestEntity guestEntity = GuestEntity.toGuestEntity(guestDto);
        guestEntityRepository.save(guestEntity);

        return findById(guestDto.getId());
    }
}
