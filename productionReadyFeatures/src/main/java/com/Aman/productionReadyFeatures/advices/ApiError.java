package com.Aman.productionReadyFeatures.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {

    public ApiError() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiError(String message, HttpStatus status) {
        this();
        this.message = message;
        this.status = status;
    }

    private LocalDateTime timeStamp;

    private String message;

    private HttpStatus status;
}
