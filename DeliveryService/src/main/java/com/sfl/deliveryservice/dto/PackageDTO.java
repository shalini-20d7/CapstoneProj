package com.sfl.deliveryservice.dto;

import lombok.Data;

@Data
public class PackageDTO {

    private Long packageId;

    private String senderName;

    private String receiverName;

    private Double packageWeight;

    private String sourceLocation;

    private String destinationLocation;

    private String packageStatus;
}