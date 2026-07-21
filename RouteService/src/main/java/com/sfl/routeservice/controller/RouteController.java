package com.sfl.routeservice.controller;

import com.sfl.routeservice.dto.RouteDTO;
import com.sfl.routeservice.entity.Route;
import com.sfl.routeservice.service.RouteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService service;

    // Register Route
    @PostMapping("/register")
    public String registerRoute(@Valid @RequestBody RouteDTO dto) {

        log.info("Method execution started : registerRoute()");

        Route route = new Route();
        route.setRouteId(dto.getRouteId());
        route.setPackageId(dto.getPackageId());
        route.setSourceLocation(dto.getSourceLocation());
        route.setDestinationLocation(dto.getDestinationLocation());
        route.setDistance(dto.getDistance());
        route.setShortestRoute(dto.getShortestRoute());

        String response = service.registerRoute(route);

        log.info("Method execution exit : registerRoute()");

        return response;
    }

    // Get All Routes
    @GetMapping("/get")
    public Iterable<Route> getAllRoutes() {

        log.info("Method execution started : getAllRoutes()");

        Iterable<Route> routes = service.getAllRoutes();

        log.info("Method execution exit : getAllRoutes()");

        return routes;
    }

    // Get Route By Id
    @GetMapping("/get/{id}")
    public Route getRouteById(@PathVariable Long id) {

        log.info("Method execution started : getRouteById()");

        Route route = service.getRouteById(id);

        log.info("Method execution exit : getRouteById()");

        return route;
    }

    // Delete Route
    @DeleteMapping("/delete/{id}")
    public String deleteRoute(@PathVariable Long id) {

        log.info("Method execution started : deleteRoute()");

        String response = service.deleteRoute(id);

        log.info("Method execution exit : deleteRoute()");

        return response;
    }
}