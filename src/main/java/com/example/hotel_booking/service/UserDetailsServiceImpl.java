package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService USER_SERVICE;

    @Autowired
    public UserDetailsServiceImpl(UserService userService){
        USER_SERVICE=userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Email: "+ username);
         UserDto userDto= USER_SERVICE.selectByEmail(username);
        if(userDto == null) {
            throw new UsernameNotFoundException(username+ "is not a valid username");
        }

        return userDto;
    }
}
