package com.example.hotel_booking.dto;

import com.example.hotel_booking.entity.BusinessEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * DTO for {@link com.example.hotel_booking.entity.BusinessEntity}
 */
@Data
public class BusinessDto implements UserDetails, Serializable{

    private BusinessEntity user;

    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    Long id;
    String businessEmail;
    String businessPassword;
    String companyName;
    String companyPhone;
    String companyAddress;
    int enabled;

    private List<GrantedAuthority> authorities;

    @Override
    public Collection getAuthorities() {
        authorities= new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(companyName));
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getBusinessPassword();
    }

    @Override
    public String getUsername() {
        return user.getBusinessEmail();
    }
    public static BusinessDto toBusinessDto(BusinessEntity businessEntity) {
        BusinessDto businessDTO= new BusinessDto();
        businessDTO.setId(businessEntity.getId());
        businessDTO.setBusinessEmail(businessEntity.getBusinessEmail());
        businessDTO.setBusinessPassword(businessEntity.getBusinessPassword());
        businessDTO.setCompanyName(businessEntity.getCompanyName());
        businessDTO.setCompanyPhone(businessEntity.getCompanyPhone());
        businessDTO.setCompanyAddress(businessEntity.getCompanyAddress());
        businessDTO.setEnabled(businessEntity.getEnabled());
        return businessDTO;
    }


}