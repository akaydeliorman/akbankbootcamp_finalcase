package com.akaydeliorman.app_weather.user.registration.controller;

import com.akaydeliorman.app_weather.auth.AuthenticationRequest;
import com.akaydeliorman.app_weather.config.JwtService;
import com.akaydeliorman.app_weather.exception.UsernameAndPasswordNotMatchException;
import com.akaydeliorman.app_weather.generic.test.GenericApiResponse;
import com.akaydeliorman.app_weather.kafkaservice.producer.KafkaService;
import com.akaydeliorman.app_weather.user.User;
import com.akaydeliorman.app_weather.user.dto.RegistrationDto;
import com.akaydeliorman.app_weather.user.repository.UserRepository;
import com.akaydeliorman.app_weather.user.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth/user-registrations")
public class UserRegistrationController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRegistrationService userRegistrationService;
    private final KafkaService kafkaService;

    @PostMapping("/app-user")
    public GenericApiResponse createServiceProviderOrganizationAdminUser(@RequestBody RegistrationDto userRegistrationDto) {
        kafkaService.sendMessage("Created user.","info-topics");
        User user = userRegistrationService.registerAppUser(userRegistrationDto.getLogin(), userRegistrationDto.getPassword());
        return new GenericApiResponse(200, "Success", "49157368", user);
    }

    @PostMapping("/authenticate")
    public GenericApiResponse authenticate(@RequestBody AuthenticationRequest request) {
        try{
            kafkaService.sendMessage("Authenticate user.","info-topics");
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));
            var user = userRepository.findByLogin(request.getLogin()).orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return new GenericApiResponse(200, "Success", "91735462", jwtToken);
        }catch (Exception e){
            throw new UsernameAndPasswordNotMatchException("Username and password incorrect!!");
        }

    }
}