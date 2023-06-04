package com.akaydeliorman.app_weather.user.repository;

import com.akaydeliorman.app_weather.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {



    Optional<User> findByLogin(String login);
}
