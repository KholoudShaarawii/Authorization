package com.ex.configg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                //  .anyRequest().authenticated()
                //.anyRequest().permitAll() //makes the endpoint public, Allow any request to pass, even if there is no Authentication. Authorization rule = allow everyone Authentication required = no, .
                //.anyRequest().denyAll() //comes after specific request rules that define authentication or roles. Close any endpoint that I did not explicitly define.
                //.anyRequest().hasAuthority("read")
                // .anyRequest().hasAnyAuthority("read","write")
                // .anyRequest().hasRole("ADMIN")
                //  .anyRequest().hasAnyRole("ADMIN", "MANAGER")
                // .anyRequest().access("isAuthenticated() and hasAuthority('read')")//SpEL expression -> A condition written as text, which Spring reads and interprets.T/F //a custom authorization decision (Role + Authority)
                //.mvcMatchers("/test1","/test3").authenticated() //No specific role is required. The only requirement is that the user must be authenticated (logged in).
                //.mvcMatchers("/test2").hasAuthority("read")
                // .mvcMatchers("/demo/*").hasAuthority("read") //One level after the prefix, /demo/test
                //  .mvcMatchers("/demo/**").hasAuthority("read") //All levels after the prefix, /demo/test  , /demo/user/profile   , /demo/user/10/orders
                //.mvcMatchers("/demo/*/*/*").hasAuthority("read") //endpoint with 3 levels after the prefix, /demo/user/profile
                .mvcMatchers(HttpMethod.GET, "/demo/**").hasAuthority("read")
                // .regexMatchers("/api/v[0-9]+/users/.*") ///api/v10/users/profile
                .anyRequest().authenticated()
                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() { // adapter between Spring Security and data
        var u = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("roz")
                .password(passwordEncoder()
                        .encode("123"))
                .authorities("read")
                //   .roles("ADMIN")
                .build();
        u.createUser(user1);

        var user2 = User.withUsername("jo")
                .password(passwordEncoder()
                        .encode("1234"))
                .authorities("write", "delete")
                //   .roles("ADMIN")
                .build();
        u.createUser(user2);
        return u;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //Hashing
    }

}
