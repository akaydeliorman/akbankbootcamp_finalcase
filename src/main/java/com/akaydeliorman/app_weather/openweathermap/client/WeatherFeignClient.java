package com.akaydeliorman.app_weather.openweathermap.client;

import com.akaydeliorman.app_weather.openweathermap.WeatherDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="openweathermap", url= "api.openweathermap.org/data/2.5/forecast")
public interface WeatherFeignClient {

    @GetMapping
    WeatherDataResponse weatherData(@RequestParam String q, @RequestParam String appid, @RequestParam String units);

}