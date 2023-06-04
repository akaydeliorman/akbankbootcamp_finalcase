package com.akaydeliorman.app_weather.openweathermap;

import com.akaydeliorman.app_weather.openweathermap.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/city/{cityName}")
    public WeatherDataResponse getFromController(@PathVariable String cityName) {

        return weatherService.getWeather(cityName);
    }

}
