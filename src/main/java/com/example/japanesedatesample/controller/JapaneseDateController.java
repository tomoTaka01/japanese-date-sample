package com.example.japanesedatesample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class JapaneseDateController {
    @RequestMapping("/")
    public String home() {
        return "test";
    }

    @PostMapping("/show")
    public String show(String inDate) {
        log.info("show inDate=[{}]", inDate);
        return "test";
    }
}
