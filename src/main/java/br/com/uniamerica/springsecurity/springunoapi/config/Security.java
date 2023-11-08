package br.com.uniamerica.springsecurity.springunoapi.config;

import br.com.uniamerica.springsecurity.springunoapi.user.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class Security {
    @Autowired
    private UserAuthService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors-> cors.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/livre").permitAll()
                        .anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        return service;
    }
}
