package com.sfl.packageservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
@Data
public class PackageDTO {
    @NotNull(message = "Package ID is required")
    private Long packageId;
    @NotBlank(message = "Sender Name is required")
    private String senderName;

    @NotBlank(message = "Receiver Name is required")
    private String receiverName;

    @NotNull(message = "Package Weight is required")
    @Positive(message = "Package Weight must be greater than 0")
    private Double packageWeight;

    @NotBlank(message = "Source Location is required")
    private String sourceLocation;

    @NotBlank(message = "Destination Location is required")
    private String destinationLocation;

    @NotBlank(message = "Package Status is required")
    private String packageStatus;

}