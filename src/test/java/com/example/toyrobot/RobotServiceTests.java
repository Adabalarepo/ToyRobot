package com.example.toyrobot;

import com.example.toyrobot.service.RobotService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RobotServiceTests {

    private RobotService robotService;

    @Before
    public void setUp() {
        robotService = new RobotService();
    }

    @Test
    public void testPlaceValidPosition() {
        robotService.place(0, 0, "NORTH");
        assertEquals("0,0,NORTH", robotService.report());
    }

    @Test
    public void testMove() {
        robotService.place(0, 0, "NORTH");
        robotService.move();
        assertEquals("0,1,NORTH", robotService.report());
    }

    @Test
    public void testLeftRotation() {
        robotService.place(0, 0, "NORTH");
        robotService.left();
        assertEquals("0,0,WEST", robotService.report());
    }

    @Test
    public void testRightRotation() {
        robotService.place(0, 0, "NORTH");
        robotService.right();
        assertEquals("0,0,EAST", robotService.report());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPlaceOutsideGrid() {
        robotService.place(5, 5, "NORTH"); // This should throw an IllegalArgumentException
    }

    @Test
    public void testMoveOffTable() {
        robotService.place(0, 0, "SOUTH");
        robotService.move();
        assertEquals("0,0,SOUTH", robotService.report());
    }
}
