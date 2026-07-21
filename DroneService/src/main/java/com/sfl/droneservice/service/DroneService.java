package com.sfl.droneservice.service;

import com.sfl.droneservice.entity.Drone;
import com.sfl.droneservice.exception.LowBatteryException;
import com.sfl.droneservice.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneService {

    @Autowired
    private DroneRepository repository;

    // Register Drone
    public String registerDrone(Drone drone) {

        // Validation 1 - Unique Drone ID
        if (repository.existsById(drone.getDroneId())) {
            return "Drone ID Already Exists";
        }

        // Validation 2 - Battery Level
        if (drone.getBatteryLevel() < 30) {
            throw new LowBatteryException("Battery Level should be greater than or equal to 30%");
        }

        repository.save(drone);

        return "Drone Registered Successfully";
    }

    // Get All Drones
    public Iterable<Drone> getAllDrones() {
        return repository.findAll();
    }

    // Get Drone By Id
    public Drone getDroneById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete Drone
    public String deleteDrone(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Drone Deleted Successfully";
        }

        return "Drone Not Found";
    }
}