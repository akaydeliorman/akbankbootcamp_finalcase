package com.akaydeliorman.app_weather.openweathermap.service;

import com.akaydeliorman.app_weather.openweathermap.WeatherDataResponse;
import com.akaydeliorman.app_weather.openweathermap.client.WeatherFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class WeatherService {

    private final String apiKey = "98104a42555fe27900ba0a45e08bf0ed";
    private final WeatherFeignClient feignClient;

    public WeatherService(WeatherFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    public WeatherDataResponse getWeather(String q) {
        return feignClient.weatherData(q,apiKey,"metric");
    }

}