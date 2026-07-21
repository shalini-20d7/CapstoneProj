package com.sfl.routeservice.service;

import com.sfl.routeservice.entity.Route;
import com.sfl.routeservice.exception.RouteNotFoundException;
import com.sfl.routeservice.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository repository;

    // Register Route
    public String registerRoute(Route route) {

        // Validation 1 - Unique Route ID
        if (repository.existsById(route.getRouteId())) {
            return "Route ID Already Exists";
        }

        // Validation 2 - Distance
        if (route.getDistance() <= 0) {
            throw new RouteNotFoundException("Distance should be greater than 0");
        }

        repository.save(route);

        return "Route Registered Successfully";
    }

    // Get All Routes
    public Iterable<Route> getAllRoutes() {
        return repository.findAll();
    }

    // Get Route By Id
    public Route getRouteById(Long id) {

        Route route = repository.findById(id).orElse(null);

        if (route == null) {
            throw new RouteNotFoundException("Route Not Found");
        }

        return route;
    }

    // Delete Route
    public String deleteRoute(Long id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return "Route Deleted Successfully";
        }

        throw new RouteNotFoundException("Route Not Found");
    }
}