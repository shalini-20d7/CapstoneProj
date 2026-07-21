package com.sfl.routeservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Route")
@Data
public class Route {

    @Id
    private Long routeId;

    private Long packageId;

    private String sourceLocation;

    private String destinationLocation;

    private Double distance;

    private String shortestRoute;
}