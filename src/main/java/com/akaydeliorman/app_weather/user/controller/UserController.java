package com.akaydeliorman.app_weather.user.controller;

import com.akaydeliorman.app_weather.generic.test.GenericApiResponse;
import com.akaydeliorman.app_weather.user.dto.DeleteCityDto;
import com.akaydeliorman.app_weather.user.dto.SavedCityDto;
import com.akaydeliorman.app_weather.user.mapper.UserMapper;
import com.akaydeliorman.app_weather.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{login}/get")
    public GenericApiResponse getUser(@PathVariable String login){
        var response = userMapper.userToDto(userService.getUserLogin(login));
        return new GenericApiResponse(200, "Success", "68486946646", response);
    }

    @DeleteMapping("/{login}/delete")
    public GenericApiResponse deleteUser(@PathVariable String login){
        userService.deleteUserLogin(login);
        return new GenericApiResponse(200, "Success", "879874");
    }

    @GetMapping("/{login}/weatherdata/savedcities")
    public GenericApiResponse getSavedWeatherCities(@PathVariable String login){
        var response = userService.getSavedWeatherCities(login);
        return new GenericApiResponse(200, "Success", "81941816", response);
    }

    @PostMapping("/{login}/new/savedcities")
    public GenericApiResponse addCityToUser(@PathVariable String login, @RequestBody SavedCityDto requestDto){
        var response = userService.addCityToUser(login, requestDto.getCity());
        return new GenericApiResponse(200, "Success", "6549846654", response);
    }

    @DeleteMapping("/{login}/delete/savedcities")
    public GenericApiResponse deleteCityFromUser(@PathVariable String login, @RequestBody DeleteCityDto requestDto){
        var response = userService.deleteCityFromUser(login, requestDto.getCity());
        return new GenericApiResponse(200, "Success", "564681351", response);
    }

}
