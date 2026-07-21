package com.sfl.deliveryservice.service;

import com.sfl.deliveryservice.dto.DroneDTO;
import com.sfl.deliveryservice.dto.PackageDTO;
import com.sfl.deliveryservice.entity.Delivery;
import com.sfl.deliveryservice.exception.BadWeatherException;
import com.sfl.deliveryservice.exception.DroneNotAvailableException;
import com.sfl.deliveryservice.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    // Assign Delivery
    public String assignDelivery(Delivery delivery) {

        // Validation 1 - Unique Delivery ID
        if (repository.existsById(delivery.getDeliveryId())) {
            return "Delivery ID Already Exists";
        }

        // Validation 2 - Drone ID should not be null
        if (delivery.getDroneId() == null) {
            throw new DroneNotAvailableException("Drone ID is required");
        }

        // ===============================
        // Call Drone Service
        // ===============================
        String droneUrl = "http://localhost:8081/drone/get/" + delivery.getDroneId();

        DroneDTO drone = restTemplate.getForObject(droneUrl, DroneDTO.class);

        // Check whether Drone exists
        if (drone == null) {
            throw new DroneNotAvailableException("Drone Not Found");
        }

        // Check Drone Availability
        if (!drone.getAvailability()) {
            throw new DroneNotAvailableException("Drone is not available");
        }

        // Check Battery Level
        if (drone.getBatteryLevel() < 30) {
            throw new DroneNotAvailableException("Drone Battery is below 30%");
        }

        // ===============================
        // Call Package Service
        // ===============================
        String packageUrl = "http://localhost:8082/package/get/" + delivery.getPackageId();

        PackageDTO packageDTO =
                restTemplate.getForObject(packageUrl, PackageDTO.class);

        // Check whether Package exists
        if (packageDTO == null) {
            return "Package Not Found";
        }

        // ===============================
        // Weather Validation
        // ===============================
        if (!delivery.getWeatherClear()) {
            throw new BadWeatherException("Weather is not clear. Delivery cannot be started.");
        }

        // Save Delivery
        repository.save(delivery);

        return "Delivery Assigned Successfully";
    }

    // Get All Deliveries
    public Iterable<Delivery> getAllDeliveries() {
        return repository.findAll();
    }

    // Get Delivery By Id
    public Delivery getDeliveryById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete Delivery
    public String deleteDelivery(Long id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return "Delivery Deleted Successfully";
        }

        return "Delivery Not Found";
    }
}