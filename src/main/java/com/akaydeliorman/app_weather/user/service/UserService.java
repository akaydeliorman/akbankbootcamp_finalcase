package com.akaydeliorman.app_weather.user.service;

import com.akaydeliorman.app_weather.openweathermap.WeatherDataResponse;
import com.akaydeliorman.app_weather.openweathermap.service.WeatherService;
import com.akaydeliorman.app_weather.user.User;
import com.akaydeliorman.app_weather.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private UserRepository userRepository;

    private final WeatherService weatherService;

    public UserService(UserRepository userRepository, WeatherService weatherService) {
        this.userRepository = userRepository;
        this.weatherService = weatherService;
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public User getUserLogin(String login) {return this.userRepository.findByLogin(login).orElseThrow();}

    public void deleteUserLogin(String login) {
        User user = getUserLogin(login);
        deleteUser(user);
    }
    public Map<String, WeatherDataResponse> getSavedWeatherCities(String login) {
        User user = getUserLogin(login);
        List<String> cities = user.getSavedCities();
        Map<String, WeatherDataResponse> citiesData = new HashMap<>();
        for (String city : cities) {
            citiesData.put(city, weatherService.getWeather(city));
        }
        return citiesData;
    }

    public User addCityToUser(String login, String city) {
        User user = getUserLogin(login);
        List<String> cities = user.getSavedCities();
        if (cities == null) {
            cities = new ArrayList<String>();
        }
        cities.add(city);
        user.setSavedCities(cities);
        userRepository.save(user);
        return user;
    }

    public User deleteCityFromUser(String login, String city) {
        User user = getUserLogin(login);
        List<String> cities = user.getSavedCities();
        cities.remove(city);
        user.setSavedCities(cities);
        userRepository.save(user);
        return user;
    }
    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }
}
