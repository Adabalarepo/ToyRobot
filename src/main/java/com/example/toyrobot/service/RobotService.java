package com.example.toyrobot.service;

import com.example.toyrobot.enums.Direction;
import com.example.toyrobot.model.Position;
import com.example.toyrobot.model.Robot;
import org.springframework.stereotype.Service;

@Service
public class RobotService {
    private final Robot robot = new Robot(); // Single instance of the robot

    /**
     * Places the robot at the specified position.
     * @param x X-coordinate (0-4).
     * @param y Y-coordinate (0-4).
     * @param facing Direction the robot will face (NORTH, SOUTH, EAST, WEST).
     */
    public void place(int x, int y, String facing) {
        Direction direction;
        try {
            direction = Direction.valueOf(facing.toUpperCase()); // This will throw an exception if the direction is invalid
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid direction: " + facing); // Throw exception for invalid direction
        }

        if (!isValidPosition(x, y)) {
            throw new IllegalArgumentException("Invalid position: (" + x + ", " + y + ")"); // Throw exception for invalid position
        }

        // If valid, place the robot at the specified position and facing
        robot.place(new Position(x, y, direction));
    }

    public void move() {
        robot.move();
    }

    public void left() {
        robot.left();
    }

    public void right() {
        robot.right();
    }

    public String report() {
        return robot.report();
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}
