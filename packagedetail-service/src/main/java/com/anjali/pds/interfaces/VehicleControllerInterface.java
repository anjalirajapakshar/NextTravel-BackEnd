package com.anjali.pds.interfaces;

import com.anjali.pds.dto.VehicleDTO;
import com.anjali.pds.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "VEHICLE-SERVICE")
public interface VehicleControllerInterface {
    @GetMapping(path = "/getVehicle")
    public VehicleDTO getVehicle(@RequestParam("vehicleId") String vehicleId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();

    @GetMapping(path = "/getVehicleByUserName", params = "VehicleBrand")
    public Response getVehicleByUserName(@RequestParam("VehicleBrand") String vehicleBrand);

    @GetMapping(path = "/getVehiclesByPackageId", params = "packageId")
    public Response getVehiclesByPackageId(@RequestParam("packageId") String packageID);
}
