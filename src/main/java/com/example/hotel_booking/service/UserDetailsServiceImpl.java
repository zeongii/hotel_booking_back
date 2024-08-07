package com.example.hotel_booking.service;

import com.example.hotel_booking.dto.BusinessDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final BusinessService BUSINESS_SERVICE;

    @Autowired
    public UserDetailsServiceImpl(BusinessService businessService){
        BUSINESS_SERVICE=businessService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("businessEmail: "+username);
         BusinessDto businessDTO= BUSINESS_SERVICE.selectByEmail(username);
        if(businessDTO == null) {
            throw new UsernameNotFoundException(username+ "is not a valid username");
        }

        return businessDTO;
    }
}
