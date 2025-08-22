package com.factoriaf5.covid_dashboard.dto.error;

import lombok.Data;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse(HttpStatus status, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
        this.path = path;
    }
}
