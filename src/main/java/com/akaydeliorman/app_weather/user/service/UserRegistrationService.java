package com.akaydeliorman.app_weather.user.service;

import com.akaydeliorman.app_weather.auth.AuthenticationRequest;
import com.akaydeliorman.app_weather.user.EnumRole;
import com.akaydeliorman.app_weather.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRegistrationService(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User registerAppUser(AuthenticationRequest authenticationRequest){
        User user = createValidUser(authenticationRequest);
        user.setLogin(user.getLogin());
        user.setPassword(bCryptPasswordEncoder.encode(authenticationRequest.getPassword()));
        user.setEnumRole(EnumRole.ROLE_USER);

        return this.userService.createUser(user);
    }
    public User createValidUser(AuthenticationRequest authRequestDto) {
        User user = new User();
        user.setLogin(authRequestDto.getLogin());
        user.setPassword(bCryptPasswordEncoder.encode(authRequestDto.getPassword()));
        return user;
    }
}
