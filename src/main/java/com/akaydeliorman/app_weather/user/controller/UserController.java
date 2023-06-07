package com.akaydeliorman.app_weather.user.controller;

import com.akaydeliorman.app_weather.exception.CityNotFoundException;
import com.akaydeliorman.app_weather.exception.IdNotFoundException;
import com.akaydeliorman.app_weather.exception.SavedCitiesNotFoundException;
import com.akaydeliorman.app_weather.exception.UserNotFoundException;
import com.akaydeliorman.app_weather.generic.test.GenericApiResponse;
import com.akaydeliorman.app_weather.kafkaservice.producer.KafkaService;
import com.akaydeliorman.app_weather.user.User;
import com.akaydeliorman.app_weather.user.dto.DeleteCityDto;
import com.akaydeliorman.app_weather.user.dto.SavedCityDto;
import com.akaydeliorman.app_weather.user.dto.UpdateDto;
import com.akaydeliorman.app_weather.user.dto.UserDto;
import com.akaydeliorman.app_weather.user.mapper.UserMapper;
import com.akaydeliorman.app_weather.user.repository.UserRepository;
import com.akaydeliorman.app_weather.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    private final KafkaService kafkaService;
    private final UserRepository userRepository;

    @GetMapping
    public List<UserDto> findAll() {
        kafkaService.sendMessage("All users fetched.","info-topics");
        List<User> userList = userRepository.findAll();
        return userMapper.userListToDto(userList);
    }

    @PutMapping
    public UserDto update(String login, UpdateDto updateDto){
        try{
            kafkaService.sendMessage("Update method called!", "info-topics");
            return userService.update(login,updateDto);
        }
        catch (Exception e){
            throw new IdNotFoundException("Id not found!");
        }
    }


    @GetMapping("/{login}/get")
    public GenericApiResponse getUser(@PathVariable String login){
        try{
            kafkaService.sendMessage("User fetched.","info-topics");
            var response = userMapper.userToDto(userService.getUserLogin(login));
            return new GenericApiResponse(200, "Success", "413453453", response);
        }catch (Exception e){
            throw new UserNotFoundException("User not found!!");
        }
    }

    @DeleteMapping("/{login}/delete")
    public GenericApiResponse deleteUser(@PathVariable String login){
        try {
            kafkaService.sendMessage("User deleted...","error-topics");
            userService.deleteUserLogin(login);
            return new GenericApiResponse(200, "Success", "3452345");
        }
        catch (Exception e){
            throw new UserNotFoundException("User not found!!");
        }
    }

    @GetMapping("/{login}/weatherdata/savedcities")
    public GenericApiResponse getSavedWeatherCities(@PathVariable String login){
        try {
            kafkaService.sendMessage("Get saved cities weather.","info-topics");
            var response = userService.getSavedWeatherCities(login);
            return new GenericApiResponse(200, "Success", "879721", response);
        }
        catch (Exception e){
            throw new SavedCitiesNotFoundException("Cities not found!!");
        }
    }

    @PostMapping("/{login}/new/savedcities")
    public GenericApiResponse addCityToUser(@PathVariable String login, @RequestBody SavedCityDto requestDto){
        try {
            kafkaService.sendMessage("Saved city.","info-topics");
            var response = userService.addCityToUser(login, requestDto.getCity());
            return new GenericApiResponse(200, "Success", "17864587", response);
        }
        catch (Exception e){
            throw new UserNotFoundException("User not found!!");
        }
    }

    @DeleteMapping("/{login}/delete/savedcities")
    public GenericApiResponse deleteCityFromUser(@PathVariable String login, @RequestBody DeleteCityDto requestDto){
        try {
            kafkaService.sendMessage("Deleted city...","error-topics");
            var response = userService.deleteCityFromUser(login, requestDto.getCity());
            return new GenericApiResponse(200, "Success", "45678312", response);
        }
        catch (Exception e){
            throw new CityNotFoundException("City not found!!");
        }
    }

}
