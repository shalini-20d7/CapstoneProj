package com.sfl.routeservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RouteDTO {

    @NotNull(message = "Route ID is required")
    private Long routeId;

    @NotNull(message = "Package ID is required")
    private Long packageId;

    @NotBlank(message = "Source Location is required")
    private String sourceLocation;

    @NotBlank(message = "Destination Location is required")
    private String destinationLocation;

    @NotNull(message = "Distance is required")
    @Positive(message = "Distance should be greater than 0")
    private Double distance;

    @NotBlank(message = "Shortest Route is required")
    private String shortestRoute;
}