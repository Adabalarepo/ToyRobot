package com.example.toyrobot.model;

public class PlaceRequest {
    private int x;
    private int y;
    private String facing; // direction as a string (e.g., "NORTH", "SOUTH", "EAST", "WEST")

    // Enum for the directions to limit facing to valid values
    public enum Direction {
        NORTH, SOUTH, EAST, WEST
    }

    // Default constructor
    public PlaceRequest() {}

    // Constructor with parameters
    public PlaceRequest(int x, int y, String facing) {
        this.x = x;
        this.y = y;
        setFacing(facing); // Use setter to validate the direction
    }

    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        // Validate the facing direction
        if (facing == null || !isValidDirection(facing)) {
            throw new IllegalArgumentException("Invalid facing direction. Must be one of: NORTH, SOUTH, EAST, WEST.");
        }
        this.facing = facing;
    }

    // Helper method to check if the direction is valid
    private boolean isValidDirection(String direction) {
        try {
            Direction.valueOf(direction.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Optional: Override toString method for better logging/printing
    @Override
    public String toString() {
        return "PlaceRequest{" +
                "x=" + x +
                ", y=" + y +
                ", facing='" + facing + '\'' +
                '}';
    }
}
