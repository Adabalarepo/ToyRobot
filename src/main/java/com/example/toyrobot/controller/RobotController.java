package com.example.toyrobot.controller;

import com.example.toyrobot.model.PlaceRequest;
import com.example.toyrobot.model.RobotResponse;
import com.example.toyrobot.service.RobotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/robot")
public class RobotController {

    private final RobotService robotService;

    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping("/place")
    public ResponseEntity<RobotResponse> place(@RequestBody PlaceRequest placeRequest) {
        try {
            robotService.place(placeRequest.getX(), placeRequest.getY(), placeRequest.getFacing());
            return new ResponseEntity<>(new RobotResponse("Robot placed successfully", robotService.report()), HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(new RobotResponse("Invalid direction or position.", null), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/move")
    public ResponseEntity<RobotResponse> move() {
        robotService.move();
        return new ResponseEntity<>(new RobotResponse("Robot moved successfully", robotService.report()), HttpStatus.OK);
    }

    @PostMapping("/left")
    public ResponseEntity<RobotResponse> left() {
        robotService.left();
        return new ResponseEntity<>(new RobotResponse("Robot turned left", robotService.report()), HttpStatus.OK);
    }

    @PostMapping("/right")
    public ResponseEntity<RobotResponse> right() {
        robotService.right();
        return new ResponseEntity<>(new RobotResponse("Robot turned right", robotService.report()), HttpStatus.OK);
    }

    @GetMapping("/report")
    public ResponseEntity<String> report() {
        return new ResponseEntity<>(robotService.report(), HttpStatus.OK);
    }
}
