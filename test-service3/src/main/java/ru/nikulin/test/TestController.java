package ru.nikulin.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class TestController {


    @GetMapping
    public String showStatus() {
        return "TEST-SERVICE2-RUNNING";
    }

}
