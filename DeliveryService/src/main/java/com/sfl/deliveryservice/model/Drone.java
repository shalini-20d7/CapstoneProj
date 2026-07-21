package com.sfl.deliveryservice.model;

import lombok.Data;

@Data
public class Drone {

    private Long droneId;
    private String droneName;
    private Integer batteryLevel;
    private Double payloadCapacity;
    private String currentLocation;
    private Boolean availability;
}