package com.anjali.pds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements SuperDTO, Serializable {
    private String vehicleID;
    private String vehicleBrand;
    private String vehicleCategory;
    private String fuelType;
    private String hybridOrNot;
    private String fuelUsage;
    private String vehicleImage;
    private String seatCapacity;
    private String vehicleType;
    private String transmissionType;
    private String driversName;
    private String driversContactNumber;
    private String driverLicenseImageLocation;

    private String packageId;
}
