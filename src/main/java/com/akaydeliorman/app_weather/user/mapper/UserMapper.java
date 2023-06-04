package com.akaydeliorman.app_weather.user.mapper;

import com.akaydeliorman.app_weather.user.User;
import com.akaydeliorman.app_weather.user.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToDto(User user);

}