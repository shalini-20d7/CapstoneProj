package com.sfl.deliveryservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Delivery")
@Data
public class Delivery {

    @Id
    private Long deliveryId;

    private Long droneId;

    private Long packageId;

    private String deliveryStatus;

    private Boolean weatherClear;
    
    private LocalDate deliveryDate;

    private String assignedTime;

    private String completedTime;

}