package com.akaydeliorman.app_weather.user.service;

import com.akaydeliorman.app_weather.auth.AuthenticationRequest;
import com.akaydeliorman.app_weather.user.EnumRole;
import com.akaydeliorman.app_weather.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserRegistrationServiceTest {

    @InjectMocks
    private UserRegistrationService userRegistrationService;

    @Mock
    private UserService userService;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Captor
    private ArgumentCaptor<User> argumentCaptor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userRegistrationService = new UserRegistrationService(userService, bCryptPasswordEncoder);
    }

    @Test
    void registerAppUser_ShouldCreateValidUserWithUserRole() {

        AuthenticationRequest authRequestDto = new AuthenticationRequest();
        authRequestDto.setLogin("username");
        authRequestDto.setPassword("password");

        User expectedUser = new User();
        expectedUser.setLogin("username");
        expectedUser.setPassword("encoded_password");
        expectedUser.setEnumRole(EnumRole.ROLE_USER);

        when(bCryptPasswordEncoder.encode(authRequestDto.getPassword())).thenReturn("encoded_password");
        when(userService.createUser(any(User.class))).thenReturn(expectedUser);


        User result = userRegistrationService.registerAppUser(authRequestDto);


        verify(userService, times(1)).createUser(argumentCaptor.capture());
        User capturedUser = argumentCaptor.getValue();

        assertEquals(expectedUser, result);
        assertEquals(expectedUser.getUsername(), capturedUser.getUsername());
        assertEquals(expectedUser.getPassword(), capturedUser.getPassword());
        assertEquals(expectedUser.getEnumRole(), capturedUser.getEnumRole());
    }

    @Test
    public void testCreateValidUser() {
        String login = "testuser";
        String password = "testpassword";
        AuthenticationRequest authRequestDto = new AuthenticationRequest();
        authRequestDto.setLogin(login);
        authRequestDto.setPassword(password);
        User validUser = userRegistrationService.createValidUser(authRequestDto);
        validUser.setEnumRole(EnumRole.ROLE_USER);
        validUser.setPassword(password);
        Mockito.when(userService.createUser(Mockito.any())).thenReturn(validUser);
        Mockito.when(bCryptPasswordEncoder.encode(Mockito.any())).thenReturn(password);
        User user = userRegistrationService.registerAppUser(authRequestDto);

        assertEquals(login, user.getLogin());
        assertEquals("testpassword", user.getPassword());
    }
}
