package com.sfl.droneservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "Drone")
@Data
public class Drone {
    @Id
    private Long droneId;
    private String droneName;
    private Integer batteryLevel;
    private Double payloadCapacity;
    private String currentLocation;
    private Boolean availability;

}