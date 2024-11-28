package com.metacoding.authblog._core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.csrf(c->c.disable());

        http.authorizeHttpRequests(r ->
                        r.requestMatchers("/s/**").authenticated().anyRequest().permitAll())
                .formLogin(f ->
                        f.loginPage("/login-form")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/"));

//        http.authorizeHttpRequests(r ->
//                        r.requestMatchers("/s/**").hasAnyRole("USER", "ADMIN")
//                                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
//                                .anyRequest().permitAll())
//                .formLogin(f ->
//                        f.loginPage("/login-form")
//                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/"));

        return http.build();
    }
}
