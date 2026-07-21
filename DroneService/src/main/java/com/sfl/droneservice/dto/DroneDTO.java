package com.sfl.droneservice.dto;
import jakarta.validation.constraints.*;
import lombok.Data;
@Data
public class DroneDTO {
    @NotNull(message = "Drone ID is required")
    private Long droneId;
    @NotBlank(message = "Drone Name is required")
    private String droneName;
    @NotNull(message = "Battery Level is required")
    @Min(value = 30, message = "Battery Level should be greater than or equal to 30")
    @Max(value = 100, message = "Battery Level should not exceed 100")
    private Integer batteryLevel;
    @NotNull(message = "Payload Capacity is required")
    @Positive(message = "Payload Capacity should be greater than 0")
    private Double payloadCapacity;
    @NotBlank(message = "Current Location is required")
    private String currentLocation;
    @NotNull(message = "Availability is required")
    private Boolean availability;
}