package com.sfl.deliveryservice.dto;

import lombok.Data;

@Data
public class DroneDTO {

    private Long droneId;
    private String droneName;
    private Integer batteryLevel;
    private Double payloadCapacity;
    private String currentLocation;
    private Boolean availability;

}