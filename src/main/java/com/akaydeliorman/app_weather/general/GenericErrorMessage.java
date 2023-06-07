package com.akaydeliorman.app_weather.general;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GenericErrorMessage {

    private LocalDateTime errorDate;
    private String message;
    private String detail;
}