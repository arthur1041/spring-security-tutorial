package com.artcruz.securitywithspring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static com.artcruz.securitywithspring.security.enums.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
        .antMatchers("/api/**").hasRole(STUDENT.name())
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();

    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails annaSmithUser = User.builder()
        .username("annasmith")
        .password(passwordEncoder.encode("12345678"))
        .roles(STUDENT.name())
        .build();

    UserDetails lindaUser = User.builder()
        .username("linda")
        .password(passwordEncoder.encode("12345678"))
        .roles(ADMIN.name())
        .build();

    UserDetails tomUser = User.builder()
        .username("tom")
        .password(passwordEncoder.encode("12345678"))
        .roles(ADMINTRAINEE.name())
        .build();

    return new InMemoryUserDetailsManager(annaSmithUser, lindaUser, tomUser);
  }

}
