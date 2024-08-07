package com.example.hotel_booking.config;

import com.example.hotel_booking.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, UserDetailsServiceImpl userDetailsService) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize)->
                        authorize
                                .requestMatchers("/user/**").permitAll()
                                .anyRequest().authenticated())
                .formLogin((form) ->
                        form
                                .usernameParameter("businessEmail")
                                .passwordParameter("businessPassword")
                                .loginPage("/login")
                                .loginProcessingUrl("/user/auth")
                                .successForwardUrl("/user/authOk")
                                .failureForwardUrl("/user/authFail"))
                .logout((logout)->
                        logout
                                .logoutUrl("/user/logOut")
                                .logoutSuccessUrl("/user/logOutSuccess")
                                .clearAuthentication(true)
                                .deleteCookies("JSESSIONID"))
                .userDetailsService(userDetailsService);

        httpSecurity.addFilterBefore(corsFilter(), UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        // AllowCredentials 3000번대에서 정보 요청하면 8080에서 정보를 보내는데 그걸 허락해주는 친구 false로 하면 못보낸다고한다.
        configuration.setAllowCredentials(true);
        // 어디로 부터 오는 요청을 허락하시겠습니까??
        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 모든 url에 configuration필터 적용 시켜! 하고 해주는것
        source.registerCorsConfiguration("/**",configuration);

        return new CorsFilter(source);
    }
}
