package com.akaydeliorman.app_weather.user.dto;

import com.akaydeliorman.app_weather.user.EnumRole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String login;

    private List<String> savedCities;

    private EnumRole enumRole;
}
