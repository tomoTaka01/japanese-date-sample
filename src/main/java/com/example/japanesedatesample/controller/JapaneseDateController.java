package com.example.japanesedatesample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
@Controller
public class JapaneseDateController {
    @RequestMapping("/")
    public String home() {
        return "test";
    }

    @PostMapping("/show")
    public String show(String inDate, Model model) {
        log.info("show inDate=[{}]", inDate);
        if (StringUtils.isEmpty(inDate)) {
            model.addAttribute("japaneseDate", "???");
        } else {
            var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            var localDate= LocalDate.parse(inDate, formatter);
            log.info("localDate=[{}]", localDate);
            var japaneseDate = JapaneseDate.from(localDate);
            model.addAttribute("japaneseDate", japaneseDate);
        }
        model.addAttribute("inDate", inDate);
        return "test";
    }
}
