package com.sfl.packageservice.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "package_details")
@Data
public class Package {
    @Id
    private Long packageId;
    private String senderName;
    private String receiverName;
    private Double packageWeight;
    private String sourceLocation;
    private String destinationLocation;
    private String packageStatus;

}