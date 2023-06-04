package com.akaydeliorman.app_weather.user.service;

import com.akaydeliorman.app_weather.user.User;
import com.akaydeliorman.app_weather.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }
}
