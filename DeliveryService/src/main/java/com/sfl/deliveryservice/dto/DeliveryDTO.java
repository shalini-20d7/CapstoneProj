package com.sfl.deliveryservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DeliveryDTO {

    @NotNull(message = "Delivery ID is required")
    private Long deliveryId;

    @NotNull(message = "Drone ID is required")
    private Long droneId;

    @NotNull(message = "Package ID is required")
    private Long packageId;

    @NotBlank(message = "Delivery Status is required")
    private String deliveryStatus;

    @NotNull(message = "Weather Status is required")
    private Boolean weatherClear;

    @NotBlank(message = "Assigned Time is required")
    private String assignedTime;

    @NotBlank(message = "Completed Time is required")
    private String completedTime;
    @NotNull(message = "Delivery Date is required")
    private LocalDate deliveryDate;

}