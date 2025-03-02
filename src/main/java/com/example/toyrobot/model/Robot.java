package com.example.toyrobot.model;

public class Robot {
    private Position position; // The current position of the robot.

    public void place(Position newPosition) {
        if (newPosition == null) {
            throw new IllegalArgumentException("Position cannot be null.");
        }
        this.position = newPosition;
    }

    public void move() {
        if (position != null) {
            Position newPosition = position.moveForward();
            if (isValidPosition(newPosition)) {
                this.position = newPosition;
            }
        } else {
            throw new IllegalStateException("Robot not placed on the grid.");
        }
    }

    public void left() {
        if (position != null) {
            this.position = position.rotateLeft();
        } else {
            throw new IllegalStateException("Robot not placed on the grid.");
        }
    }

    public void right() {
        if (position != null) {
            this.position = position.rotateRight();
        } else {
            throw new IllegalStateException("Robot not placed on the grid.");
        }
    }

    public String report() {
        return (position != null) ? 
            position.getX() + "," + position.getY() + "," + position.getFacing() 
            : "Robot not placed";
    }

    private boolean isValidPosition(Position pos) {
        return pos.getX() >= 0 && pos.getX() < 5 && pos.getY() >= 0 && pos.getY() < 5;
    }
}
