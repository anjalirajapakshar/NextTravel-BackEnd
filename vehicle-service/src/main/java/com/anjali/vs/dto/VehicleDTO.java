package com.anjali.vs.dto;

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
