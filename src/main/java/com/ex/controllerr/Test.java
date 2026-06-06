package com.ex.controllerr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo") //prefix
public class Test {

    @GetMapping("/test1") //.mvcMatchers("/demo/*").hasRole("ADMIN")
    public String test1() {

        return "test1";
    }


    @GetMapping("/test2")  //.mvcMatchers("/demo/*").hasRole("ADMIN")
    public String test2() {

        return "test2";
    }
    @GetMapping("/users/profile") //.mvcMatchers("/demo/*/*").hasRole("ADMIN")
    public String profile() {
        return "profile";
    }

    @PostMapping("/users/10/orders") //.mvcMatchers("/demo/*/*/*").hasRole("ADMIN")
    public String orders() {
        return "orders";
    }
}