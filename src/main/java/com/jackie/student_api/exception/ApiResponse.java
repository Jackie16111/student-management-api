package com.jackie.student_api.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ApiResponse<T>
{
    private boolean success;
    private String message;
    private List<String> errors;
    private int status;
    private LocalDateTime timestamp;
    private T data ;

    public ApiResponse(int status, String message, T data) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getters
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public List<String> getErrors() { return errors; }
    public int getStatus() { return status; }
    public LocalDateTime getTimestamp() { return timestamp; }
}