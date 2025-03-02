package com.example.toyrobot.model;

/**
 * A class representing the standard response format for robot commands.
 */
public class RobotResponse {
    private String message;  // Message describing the outcome of the action.
    private String position; // The current position of the robot (if applicable).

    public RobotResponse(String message, String position) {
        this.message = message;
        this.position = position;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
