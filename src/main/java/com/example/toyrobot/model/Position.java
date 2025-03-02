package com.example.toyrobot.model;

import com.example.toyrobot.enums.Direction;

public class Position {
    private int x;
    private int y;
    private Direction facing;

    public Position(int x, int y, Direction facing) {
        if (facing == null) {
            throw new IllegalArgumentException("Direction cannot be null.");
        }
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Direction getFacing() { return facing; }

    public Position moveForward() {
        switch (facing) {
            case NORTH: return new Position(x, y + 1, facing);
            case SOUTH: return new Position(x, y - 1, facing);
            case EAST:  return new Position(x + 1, y, facing);
            case WEST:  return new Position(x - 1, y, facing);
            default: throw new IllegalStateException("Invalid direction");
        }
    }

    public Position rotateLeft() {
        return new Position(x, y, facing.left());
    }

    public Position rotateRight() {
        return new Position(x, y, facing.right());
    }
}
