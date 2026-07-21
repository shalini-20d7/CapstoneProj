package com.sfl.droneservice.controller;

import com.sfl.droneservice.dto.DroneDTO;
import com.sfl.droneservice.entity.Drone;
import com.sfl.droneservice.service.DroneService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/drone")
public class DroneController {

    @Autowired
    private DroneService service;

    // Register Drone
    @PostMapping("/register")
    public String registerDrone(@Valid @RequestBody DroneDTO dto) {

        log.info("Method execution started : registerDrone()");

        Drone drone = new Drone();
        drone.setDroneId(dto.getDroneId());
        drone.setDroneName(dto.getDroneName());
        drone.setBatteryLevel(dto.getBatteryLevel());
        drone.setPayloadCapacity(dto.getPayloadCapacity());
        drone.setCurrentLocation(dto.getCurrentLocation());
        drone.setAvailability(dto.getAvailability());

        String response = service.registerDrone(drone);

        log.info("Method execution exit : registerDrone()");

        return response;
    }

    // Get All Drones
    @GetMapping("/get")
    public Iterable<Drone> getAllDrones() {

        log.info("Method execution started : getAllDrones()");

        Iterable<Drone> drones = service.getAllDrones();

        log.info("Method execution exit : getAllDrones()");

        return drones;
    }

    // Get Drone By Id
    @GetMapping("/get/{id}")
    public Drone getDroneById(@PathVariable Long id) {

        log.info("Method execution started : getDroneById()");

        Drone drone = service.getDroneById(id);

        log.info("Method execution exit : getDroneById()");

        return drone;
    }

    // Delete Drone
    @DeleteMapping("/delete/{id}")
    public String deleteDrone(@PathVariable Long id) {

        log.info("Method execution started : deleteDrone()");

        String response = service.deleteDrone(id);

        log.info("Method execution exit : deleteDrone()");

        return response;
    }
}