package com.sharetute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.mvcMatcher("/articles/**")
          .authorizeRequests()
          .mvcMatchers("/articles/**")
          .access("hasAuthority('SCOPE_read')")
          .and()
          .oauth2ResourceServer()
          .jwt(Customizer.withDefaults());
        return http.build();
    }
}