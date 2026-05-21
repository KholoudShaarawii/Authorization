package com.ex.controllerr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/demo")
    public String demo() {

        return "Demo!";
    }
}