package com.anjali.vs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    @Id
    private String vehicleID;
    private String vehicleBrand;
    private String vehicleCategory;
    private String fuelType;
    private String hybridOrNot;
    private int fuelUsage;
    private int feeForDay;
    private int feeForOnekm;
    private String vehicleImage;
    private int seatCapacity;
    private String vehicleType;
    private String transmissionType;
    private String driversName;
    private String driversContactNumber;
    private String driverLicenseImageLocation;

    private String packageId;
}
