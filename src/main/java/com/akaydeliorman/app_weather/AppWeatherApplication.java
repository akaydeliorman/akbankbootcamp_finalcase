package com.akaydeliorman.app_weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppWeatherApplication.class, args);
    }

}
