package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.UserDto;
import com.example.hotel_booking.entity.UserEntity;
import com.example.hotel_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDto findById(Long id) {
        Optional<UserEntity> guestEntityOptional = userRepository.findById(id);
        if (guestEntityOptional.isPresent()) {
            UserEntity guestEntity = guestEntityOptional.get();
            UserDto guestDto = UserDto.toGuestDto(guestEntity);
            return guestDto;
        } else {
            return null;
        }
    }

    public UserDto update(UserDto guestDto) {
        userRepository.save(UserEntity.toGuestEntity(guestDto));

        return findById(guestDto.getId());
    }

    public Optional<UserEntity> findByEmailAndNameAndPhone(String email, String name, String phone) {
        return userRepository.findByEmailAndNameAndPhone(email, name, phone);
    }

    public String getPassword(UserEntity user) {
        // 나중에 수정해야해 이건 테스트용
        return user.getPassword();
    }

    public Optional<UserEntity> findByNameAndPhone(String name, String phone) {
        return userRepository.findByNameAndPhone(name, phone);
    }
    public Optional<UserEntity> auth(String email, String password) {
        System.out.println("Received email: " + email);  // 이메일 출력
        System.out.println("Received password: " + password);  // 비밀번호 출력
        Optional<UserEntity> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
           /* if (passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(user);
            }*/
            if (password.equals(user.getPassword())) {  // 평문 비교
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public boolean checkPassword(Long userId, String password) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            // 비밀번호를 암호화 체크 해야함
            return user.getPassword().equals(password);
        } else {
            return false; // 사용자가 존재하지 않는 경우
        }
    }
}
