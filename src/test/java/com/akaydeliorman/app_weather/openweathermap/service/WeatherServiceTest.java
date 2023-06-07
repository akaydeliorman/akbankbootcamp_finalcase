package com.akaydeliorman.app_weather.openweathermap.service;

import com.akaydeliorman.app_weather.openweathermap.WeatherDataResponse;
import com.akaydeliorman.app_weather.openweathermap.client.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {
    @Mock
    private WeatherFeignClient feignClient;

    @InjectMocks
    private WeatherService weatherService;

    @Test
    public void getWeather_ShouldReturnWeatherDTO() {
        WeatherDataResponse weatherDTO = new WeatherDataResponse();
        when(feignClient.weatherData("city", "98104a42555fe27900ba0a45e08bf0ed", "metric")).thenReturn(weatherDTO);
        WeatherDataResponse city = weatherService.getWeather("city");
        assertEquals(weatherDTO, city);

    }
}