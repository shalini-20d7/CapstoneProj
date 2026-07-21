package com.sfl.deliveryservice.controller;

import com.sfl.deliveryservice.dto.DeliveryDTO;
import com.sfl.deliveryservice.entity.Delivery;
import com.sfl.deliveryservice.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    // Assign Delivery
    @PostMapping("/assign")
    public String assignDelivery(@Valid @RequestBody DeliveryDTO dto) {

        log.info("Method execution started : assignDelivery()");

        Delivery delivery = new Delivery();
        delivery.setDeliveryId(dto.getDeliveryId());
        delivery.setDroneId(dto.getDroneId());
        delivery.setPackageId(dto.getPackageId());
        delivery.setDeliveryStatus(dto.getDeliveryStatus());
        delivery.setWeatherClear(dto.getWeatherClear());
        delivery.setDeliveryDate(dto.getDeliveryDate());
        delivery.setAssignedTime(dto.getAssignedTime());
        delivery.setCompletedTime(dto.getCompletedTime());

        String response = service.assignDelivery(delivery);

        log.info("Method execution exit : assignDelivery()");

        return response;
    }

    // Get All Deliveries
    @GetMapping("/get")
    public Iterable<Delivery> getAllDeliveries() {

        log.info("Method execution started : getAllDeliveries()");

        Iterable<Delivery> deliveries = service.getAllDeliveries();

        log.info("Method execution exit : getAllDeliveries()");

        return deliveries;
    }

    // Get Delivery By Id
    @GetMapping("/get/{id}")
    public Delivery getDeliveryById(@PathVariable Long id) {

        log.info("Method execution started : getDeliveryById()");

        Delivery delivery = service.getDeliveryById(id);

        log.info("Method execution exit : getDeliveryById()");

        return delivery;
    }

    // Delete Delivery
    @DeleteMapping("/delete/{id}")
    public String deleteDelivery(@PathVariable Long id) {

        log.info("Method execution started : deleteDelivery()");

        String response = service.deleteDelivery(id);

        log.info("Method execution exit : deleteDelivery()");

        return response;
    }
}