package com.example.cloudtasks; // Ensure this matches your package structure

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private String message;
    private String timestamp;
    private List<String> details;

    public ErrorResponse(String message, List<String> details) {
        this.message = message;
        this.timestamp = LocalDateTime.now().toString();
        this.details = details;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}

