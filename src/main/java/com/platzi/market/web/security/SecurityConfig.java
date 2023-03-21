package com.platzi.market.web.security;


import com.platzi.market.domain.service.PlatziUserDetailsService;
import com.platzi.market.web.security.filter.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfig{
    @Autowired
    private PlatziUserDetailsService projectUserDetailsService;

    @Autowired
    private JwtFilterRequest jwtFilterRequest;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(projectUserDetailsService)
                .and()
                .build();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .and()
                .build();
    }

         /*/http.csrf().disable().authorizeRequests().anyRequest()
                .authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
         //http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
         return http.build();/*/

}
//antMatchers("/**/authenticate").permitAll()