package com.example.toyrobot;

import com.example.toyrobot.controller.RobotController;
import com.example.toyrobot.model.PlaceRequest;
import com.example.toyrobot.model.RobotResponse;
import com.example.toyrobot.service.RobotService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RobotControllerTests {

    @Mock
    private RobotService robotService;

    private RobotController robotController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        robotController = new RobotController(robotService);
    }

    @Test
    public void testPlaceValidPosition() {
        // Arrange
        when(robotService.report()).thenReturn("0,0,NORTH");
        PlaceRequest request = new PlaceRequest(0, 0, "NORTH");

        // Act
        ResponseEntity<RobotResponse> response = robotController.place(request);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Robot placed successfully", response.getBody().getMessage());
        assertEquals("0,0,NORTH", response.getBody().getPosition());
    }

    @Test
    public void testMove() {
        // Arrange
        when(robotService.report()).thenReturn("0,1,NORTH");

        // Act
        ResponseEntity<RobotResponse> response = robotController.move();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Robot moved successfully", response.getBody().getMessage());
        assertEquals("0,1,NORTH", response.getBody().getPosition());
    }

    @Test
    public void testLeftRotation() {
        // Arrange
        when(robotService.report()).thenReturn("0,0,WEST");

        // Act
        ResponseEntity<RobotResponse> response = robotController.left();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Robot turned left", response.getBody().getMessage());
        assertEquals("0,0,WEST", response.getBody().getPosition());
    }

    @Test
    public void testRightRotation() {
        // Arrange
        when(robotService.report()).thenReturn("0,0,EAST");

        // Act
        ResponseEntity<RobotResponse> response = robotController.right();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Robot turned right", response.getBody().getMessage());
        assertEquals("0,0,EAST", response.getBody().getPosition());
    }

    @Test
    public void testInvalidPlaceOutsideGrid() {
        // Arrange: Simulate invalid placement
        doThrow(new IllegalArgumentException("Invalid position")).when(robotService).place(5, 5, "NORTH");
        PlaceRequest request = new PlaceRequest(5, 5, "NORTH");

        // Act
        ResponseEntity<RobotResponse> response = robotController.place(request);

        // Assert: Verify the status code and error message for invalid place
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid direction or position.", response.getBody().getMessage());
        assertNull(response.getBody().getPosition());
    }

    @Test
    public void testMoveOffTable() {
        // Arrange
        when(robotService.report()).thenReturn("0,0,SOUTH");

        // Act
        ResponseEntity<RobotResponse> response = robotController.move();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Robot moved successfully", response.getBody().getMessage());
        assertEquals("0,0,SOUTH", response.getBody().getPosition());
    }
}
