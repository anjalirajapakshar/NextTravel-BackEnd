package com.anjali.vs.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "PACKAGE-SERVICE")
public interface PackagesControllerInterface {
    @PutMapping( value = "/getVehicleId",params = {"vehicleID","packageID"})
    public void getVehicleIds(@RequestParam("vehicleID") String Vehicleid, @RequestParam("packageID") String Packageid);

    @PutMapping( value = "/getVehicleIdsForDelete",params = {"vehicleID","packageID"})
    public void getVehicleIdsForDeleteHotel(@RequestParam("vehicleID") String VehicleID, @RequestParam("packageID") String Packageid);
}
