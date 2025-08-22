package ru.nikulin.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestService {

    public static void main(String[] args) {
        SpringApplication.run(TestService.class, args);
    }
}
