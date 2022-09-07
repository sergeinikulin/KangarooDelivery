package ru.kangaroodelivery.reports.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simpleCheckJobController")
public class SimpleCheckJobController {

    @GetMapping
    public String getCheck() {
        return "its Job!";
    }
}
