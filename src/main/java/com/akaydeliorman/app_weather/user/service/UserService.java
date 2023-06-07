package com.akaydeliorman.app_weather.user.service;

import com.akaydeliorman.app_weather.kafkaservice.producer.KafkaService;
import com.akaydeliorman.app_weather.openweathermap.WeatherDataResponse;
import com.akaydeliorman.app_weather.openweathermap.service.WeatherService;
import com.akaydeliorman.app_weather.user.User;
import com.akaydeliorman.app_weather.user.dto.UpdateDto;
import com.akaydeliorman.app_weather.user.dto.UserDto;
import com.akaydeliorman.app_weather.user.mapper.UserMapper;
import com.akaydeliorman.app_weather.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

import java.util.*;

@Service

public class UserService {
    private UserRepository userRepository;

    private final WeatherService weatherService;
    private final KafkaService kafkaService;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, WeatherService weatherService, KafkaService kafkaService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.weatherService = weatherService;
        this.kafkaService = kafkaService;
        this.userMapper = userMapper;
    }


    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public User getUserLogin(String login) {
        return this.userRepository.findByLogin(login)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }


    public void deleteUserLogin(String login) {
        kafkaService.sendMessage("DELETED!","topics");
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
        List<String> cities = new ArrayList<>(user.getSavedCities());
        cities.remove(city);
        user.setSavedCities(cities);
        userRepository.save(user);
        return user;
    }
    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    public UserDto update(String login, UpdateDto updateDto){
        User user = userRepository.findByLogin(login).orElseThrow();
        user.setLogin(updateDto.getUsername());
        userRepository.save(user);
        return userMapper.userToDto(user);
    }
}
