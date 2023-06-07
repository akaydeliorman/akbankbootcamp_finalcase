package com.akaydeliorman.app_weather.openweathermap;

import com.akaydeliorman.app_weather.exception.CityNotFoundException;
import com.akaydeliorman.app_weather.kafkaservice.producer.KafkaService;
import com.akaydeliorman.app_weather.openweathermap.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final KafkaService kafkaService;

    public WeatherController(WeatherService weatherService, KafkaService kafkaService) {
        this.weatherService = weatherService;
        this.kafkaService = kafkaService;
    }

    @GetMapping("/city/{cityName}")
    public WeatherDataResponse getFromController(@PathVariable String cityName) {
        try {
            kafkaService.sendMessage("Get city...","topics");
            return weatherService.getWeather(cityName);
        }catch (Exception e){
            throw new CityNotFoundException("City not found !!");
        }
    }

}
