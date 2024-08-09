package com.example.hotel_booking.controller;

import com.example.hotel_booking.dto.UserDto;
import com.example.hotel_booking.entity.UserEntity;
import com.example.hotel_booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("forgot-username")
    public ResponseEntity<Map<String, Object>> forgotUsername(@RequestBody Map<String, String> request) {
        String name = request.get("name");
        String phone = request.get("phone");
        Map<String, Object> resultMap = new HashMap<>();

        try {
            Optional<UserEntity> userOptional = userService.findByNameAndPhone(name, phone);
            if (userOptional.isPresent()) {
                UserEntity user = userOptional.get();
                resultMap.put("result", "success");
                resultMap.put("email", user.getEmail());
                return ResponseEntity.ok(resultMap);
            } else {
                resultMap.put("result", "fail");
                resultMap.put("message", "User not found");
                return ResponseEntity.status(404).body(resultMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", "fail");
            resultMap.put("message", e.getMessage());
            return ResponseEntity.status(500).body(resultMap);
        }
    }


    @RequestMapping("authFail")
    public ResponseEntity<Map<String, Object>> authFail() {
        System.out.println("Auth has failed :(");
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", "fail");

        return ResponseEntity.ok(resultMap);
    }

    @PostMapping("forgot-password")
    public ResponseEntity<Map<String, Object>> forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String name = request.get("name");
        String phone = request.get("phone");
        Map<String, Object> resultMap = new HashMap<>();

        try {
            Optional<UserEntity> userOptional = userService.findByEmailAndNameAndPhone(email, name, phone);
            if (userOptional.isPresent()) {
                UserEntity user = userOptional.get();
                if (user.getName().equals(name) && user.getPhone().equals(phone)) {
                    String password = userService.getPassword(user); // 비밀번호 반환
                    resultMap.put("result", "success");
                    resultMap.put("password", password); // 주의: 해시된 비밀번호가 반환됩니다.
                    return ResponseEntity.ok(resultMap);
                } else {
                    resultMap.put("result", "fail");
                    resultMap.put("message", "일치하는 정보가 없습니다.");
                    return ResponseEntity.status(404).body(resultMap);
                }
            } else {
                resultMap.put("result", "fail");
                resultMap.put("message", "찾기 실패");
                return ResponseEntity.status(404).body(resultMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", "fail");
            resultMap.put("message", e.getMessage());
            return ResponseEntity.status(500).body(resultMap);
        }


    }
}


