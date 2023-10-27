package com.anjali.vs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements SuperDTO, Serializable {

    @Valid
    private String vehicleID;

    @NotNull(message = "vehicleBrand cannot be null")
    @Size(min = 2,max = 30,message = "vehicleBrand must be between 2 and 30 characters")
    @NotBlank(message = "vehicleBrand cannot be blank")
    private String vehicleBrand;

    @NotNull(message = "vehicleCategory cannot be null")
    @Size(min = 2,max = 20,message = "vehicleCategory must be between 2 and 20 characters")
    @NotBlank(message = "vehicleCategory cannot be blank")
    private String vehicleCategory;

    @NotNull(message = "fuelType cannot be null")
    @Size(min = 2,max = 20,message = "fuelType must be between 2 and 20 characters")
    @NotBlank(message = "fuelType cannot be blank")
    private String fuelType;

    @NotNull(message = "hybridOrNot cannot be null")
    @Size(min = 2,max = 3,message = "hybridOrNot must be between 2 and 3 characters")
    @NotBlank(message = "hybridOrNot cannot be blank")
    private String hybridOrNot;

    @NotNull(message = "fuelUsage cannot be null")
    @Min(value = 1, message = "fuelUsage must be at least 1")
    @Max(value = 1000, message = "fuelUsage cannot be greater than 1000")
    private int fuelUsage;

    @NotNull(message = "feeForDay cannot be null")
    @Min(value = 1000, message = "guideAge must be at least 1")
//    @Max(value = 2, message = "guideAge cannot be greater than 2")
    private int feeForDay;

    @NotNull(message = "feeForOnekm cannot be null")
//    @Min(value = 1000, message = "guideAge must be at least 1")
//    @Max(value = 2, message = "guideAge cannot be greater than 2")
    private int feeForOnekm;

    @NotNull(message = "vehicleImage cannot be null")
    @Size(min = 2,max = 50,message = "vehicleImage must be between 2 and 50 characters")
    @NotBlank(message = "vehicleImage cannot be blank")
    private String vehicleImage;

    @NotNull(message = "seatCapacity cannot be null")
    @Min(value = 1, message = "seatCapacity must be at least 1")
    @Max(value = 100, message = "seatCapacity cannot be greater than 100")
    private int seatCapacity;

    @NotNull(message = "vehicleType cannot be null")
    @Size(min = 2,max = 50,message = "vehicleType must be between 2 and 50 characters")
    @NotBlank(message = "vehicleType cannot be blank")
    private String vehicleType;

    @NotNull(message = "transmissionType cannot be null")
    @Size(min = 2,max = 50,message = "transmissionType must be between 2 and 50 characters")
    @NotBlank(message = "transmissionType cannot be blank")
    private String transmissionType;

    @NotNull(message = "driversName cannot be null")
    @Size(min = 2,max = 50,message = "driversName must be between 2 and 50 characters")
    @NotBlank(message = "driversName cannot be blank")
    private String driversName;

    @NotNull(message = "driversContactNumber cannot be null")
    @Size(min = 2,max = 10,message = "driversContactNumber must be between 2 and 10 characters")
    @NotBlank(message = "driversContactNumber cannot be blank")
    private String driversContactNumber;

    @NotNull(message = "driverLicenseImageLocation cannot be null")
    @Size(min = 2,max = 50,message = "driverLicenseImageLocation must be between 2 and 50 characters")
    @NotBlank(message = "driverLicenseImageLocation cannot be blank")
    private String driverLicenseImageLocation;

    @NotNull(message = "packageId cannot be null")
    @Size(min = 2,max = 5,message = "packageId must be between 2 and 5 characters")
    @NotBlank(message = "packageId cannot be blank")
    private String packageId;
}

//
//{
//        "vehicleID": "V001",
//        "vehicleBrand": "Suzuki Celerio",
//        "vehicleCategory": "SUV",
//        "fuelType": "P/M",
//        "hybridOrNot": "No",
//        "fuelUsage": 22,
//        "feeForDay": 4500,
//        "feeForOnekm": 95,
//        "vehicleImage": "https://example.com/images/car.jpg",
//        "seatCapacity": 4,
//        "vehicleType": "Compact",
//        "transmissionType": "Automatic",
//        "driversName": "John Doe",
//        "driversContactNumber": "0775468956",
//        "driverLicenseImageLocation": "https://example.com/images/driver_license.jpg",
//        "packageId": "P001"
//}
//
//{
//        "vehicleID": "V002",
//        "vehicleBrand": "Toyota Yaris",
//        "vehicleCategory": "SUV",
//        "fuelType": "P/A",
//        "hybridOrNot": "No",
//        "fuelUsage": 15,
//        "feeForDay": 8500,
//        "feeForOnekm": 180,
//        "vehicleImage": "https://example.com/images/car.jpg",
//        "seatCapacity": 4,
//        "vehicleType": "Compact",
//        "transmissionType": "Automatic",
//        "driversName": "kamal",
//        "driversContactNumber": "0775468956",
//        "driverLicenseImageLocation": "https://example.com/images/driver_license.jpg",
//        "packageId": "P002"
//}
//
//{
//        "vehicleID": "V003",
//        "vehicleBrand": "Toyota Coaster",
//        "vehicleCategory": "SUV",
//        "fuelType": "D/M",
//        "hybridOrNot": "Yes",
//        "fuelUsage": 7,
//        "feeForDay": 50000,
//        "feeForOnekm": 500,
//        "vehicleImage": "https://example.com/images/car.jpg",
//        "seatCapacity": 30,
//        "vehicleType": "Compact",
//        "transmissionType": "Automatic",
//        "driversName": "Nimal",
//        "driversContactNumber": "0775468956",
//        "driverLicenseImageLocation": "https://example.com/images/driver_license.jpg",
//        "packageId": "P003"
//}
//
//{
//        "vehicleID": "V004",
//        "vehicleBrand": "Toyota KDH",
//        "vehicleCategory": "SUV",
//        "fuelType": "D/A",
//        "hybridOrNot": "No",
//        "fuelUsage": 10,
//        "feeForDay": 45000,
//        "feeForOnekm": 400,
//        "vehicleImage": "https://example.com/images/car.jpg",
//        "seatCapacity": 9,
//        "vehicleType": "Compact",
//        "transmissionType": "Automatic",
//        "driversName": "Namal",
//        "driversContactNumber": "0775468956",
//        "driverLicenseImageLocation": "https://example.com/images/driver_license.jpg",
//        "packageId": "P003"
//}
//
//{
//        "vehicleID": "V005",
//        "vehicleBrand": "Toyota Alphard",
//        "vehicleCategory": "SUV",
//        "fuelType": "D/A",
//        "hybridOrNot": "No",
//        "fuelUsage": 10,
//        "feeForDay": 65000,
//        "feeForOnekm": 650,
//        "vehicleImage": "https://example.com/images/car.jpg",
//        "seatCapacity": 7,
//        "vehicleType": "Compact",
//        "transmissionType": "Automatic",
//        "driversName": "Amal",
//        "driversContactNumber": "0775468956",
//        "driverLicenseImageLocation": "https://example.com/images/driver_license.jpg",
//        "packageId": "P004"
//}
