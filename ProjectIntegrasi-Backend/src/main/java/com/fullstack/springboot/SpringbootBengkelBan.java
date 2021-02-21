package com.fullstack.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.fullstack.springboot"})
public class SpringbootBengkelBan {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootBengkelBan.class, args);
    }
}

