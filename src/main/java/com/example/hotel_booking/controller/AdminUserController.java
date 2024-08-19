package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.UserDto;
import com.example.hotel_booking.entity.UserEntity;
import com.example.hotel_booking.service.AdminUserService;
import com.example.hotel_booking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @GetMapping("/userList")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = adminUserService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        UserEntity user = adminUserService.findById(id);
        System.out.println("AdminUserController.getUserById");
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody UserEntity id) {

        return null;
    }

    @PostMapping("/update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity) {
        UserEntity updateUser = adminUserService.findById(userEntity.getId());

        updateUser.setAddress(userEntity.getAddress());
        updateUser.setPhone(userEntity.getPhone());
        updateUser.setEmail(userEntity.getEmail());
        updateUser.setRole(userEntity.getRole());

        UserEntity savedUser = adminUserService.save(updateUser);
        return ResponseEntity.ok(savedUser);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        adminUserService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/incrementVisitor")
    public Map<String, Long> incrementVisitorCount(@RequestParam("user_id") Long userId) {
        Long updatedVisitorCount = adminUserService.incrementVisitorCount(userId);
        return Map.of("visitorCount", updatedVisitorCount);
    }


}