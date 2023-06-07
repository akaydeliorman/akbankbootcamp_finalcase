package com.akaydeliorman.app_weather.user.service;

import com.akaydeliorman.app_weather.kafkaservice.producer.KafkaService;
import com.akaydeliorman.app_weather.openweathermap.WeatherDataResponse;
import com.akaydeliorman.app_weather.openweathermap.service.WeatherService;
import com.akaydeliorman.app_weather.user.User;
import com.akaydeliorman.app_weather.user.mapper.UserMapper;
import com.akaydeliorman.app_weather.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private WeatherService weatherService;

    @Mock
    private KafkaService kafkaService;

    @InjectMocks
    private UserService userService;
    @Mock
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, weatherService, kafkaService, userMapper);
    }

    @Test
    void createUser_ShouldSaveUser() {
        User user = new User();
        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.createUser(user);

        verify(userRepository, times(1)).save(user);
        assertEquals(user, savedUser);
    }

    @Test
    void getUserLogin_ExistingLogin_ShouldReturnUser() {
        User user = new User();
        when(userRepository.findByLogin(anyString())).thenReturn(Optional.of(user));

        User foundUser = userService.getUserLogin("login");

        verify(userRepository, times(1)).findByLogin("login");
        assertEquals(user, foundUser);
    }

    @Test
    void getUserLogin_NonExistingLogin_ShouldThrowException() {
        when(userRepository.findByLogin(anyString())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userService.getUserLogin("nonExistingLogin"));

        verify(userRepository, times(1)).findByLogin("nonExistingLogin");
    }

    @Test
    void deleteUserLogin_ShouldDeleteUserAndSendMessageToKafka() {
        User user = new User();
        when(userRepository.findByLogin(anyString())).thenReturn(Optional.of(user));

        userService.deleteUserLogin("login");

        verify(userRepository, times(1)).findByLogin("login");
        verify(userRepository, times(1)).delete(user);
        verify(kafkaService, times(1)).sendMessage("DELETED!", "topics");
    }

    @Test
    void getSavedWeatherCities_ShouldReturnWeatherDataForSavedCities() {
        
        String username = "username";
        User user = new User();
        user.setSavedCities(List.of("city1", "city2"));
        when(userRepository.findByLogin(anyString())).thenReturn(Optional.of(user));

        WeatherDataResponse weatherDTO1 = new WeatherDataResponse();
        WeatherDataResponse weatherDTO2 = new WeatherDataResponse();
        when(weatherService.getWeather("city1")).thenReturn(weatherDTO1);
        when(weatherService.getWeather("city2")).thenReturn(weatherDTO2);


        Map<String, WeatherDataResponse> result = userService.getSavedWeatherCities(username);


        Map<String, WeatherDataResponse> expectedData = new HashMap<>();
        expectedData.put("city1", weatherDTO1);
        expectedData.put("city2", weatherDTO2);

        assertEquals(expectedData, result);
        verify(userRepository, times(1)).findByLogin(username);
        verify(weatherService, times(1)).getWeather("city1");
        verify(weatherService, times(1)).getWeather("city2");
    }

    @Test
    void addCityToUser_ShouldAddCityToUser() {
        User user = new User();
        when(userRepository.findByLogin(anyString())).thenReturn(Optional.of(user));

        User updatedUser = userService.addCityToUser("login", "city");

        verify(userRepository, times(1)).findByLogin("login");
        verify(userRepository, times(1)).save(user);
        assertEquals(List.of("city"), updatedUser.getSavedCities());
    }

    @Test
    void deleteCityFromUser_ShouldDeleteCityFromUser() {
        User user = new User();
        user.setSavedCities(List.of("city1", "city2"));
        when(userRepository.findByLogin(anyString())).thenReturn(Optional.of(user));

        User updatedUser = userService.deleteCityFromUser("login", "city1");

        verify(userRepository, times(1)).findByLogin("login");
        verify(userRepository, times(1)).save(user);
        assertEquals(List.of("city2"), updatedUser.getSavedCities());
    }

    @Test
    void deleteUser_ShouldDeleteUser() {
        User user = new User();

        userService.deleteUser(user);

        verify(userRepository, times(1)).delete(user);
    }
}