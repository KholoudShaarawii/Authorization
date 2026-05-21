package com.ex.configg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic()
                .and()
                .authorizeRequests()
                //.anyRequest().authenticated()
                //.anyRequest().permitAll() //makes the endpoint public, Allow any request to pass, even if there is no Authentication. Authorization rule = allow everyone Authentication required = no, .
               //.anyRequest().denyAll() //comes after specific request rules that define authentication or roles. Close any endpoint that I did not explicitly define.
               //.anyRequest().hasAuthority("read")
               // .anyRequest().hasAnyAuthority("read","write")
               // .anyRequest().hasRole("ADMIN")
              //  .anyRequest().hasAnyRole("ADMIN", "MANAGER")
               // .anyRequest().access("isAuthenticated() and hasAuthority('read')")//SpEL expression -> A condition written as text, which Spring reads and interprets.T/F //a custom authorization decision (Role + Authority)
              //  .mvcMatchers()
                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() { // adapter between Spring Security and data
        var u = new InMemoryUserDetailsManager();
        var user = User.withUsername("roz")
                   .password(passwordEncoder()
                   .encode("123"))
                   .authorities("read")
                   .roles("ADMIN")
                   .build();
        u.createUser(user);
        return u;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //Hashing
    }

}
