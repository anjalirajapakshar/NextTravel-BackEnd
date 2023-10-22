package com.anjali.uas.endpoints;

import com.anjali.uas.dto.VehicleDTO;
import com.anjali.uas.interfaces.VehicleControllerInterface;
import com.anjali.uas.model.Vehicle;
import com.anjali.uas.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    private VehicleControllerInterface vehicleControllerInterface;

    @PostMapping(path = "/sv", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleControllerInterface.saveVehicle(vehicleDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleControllerInterface.update(vehicleDTO);
    }

    @GetMapping(path = "/search", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("vehicleId") String vehicleId) {
        return vehicleControllerInterface.search(vehicleId);
    }

    @DeleteMapping(path = "/delete", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("vehicleId") String vehicleId) {
        return vehicleControllerInterface.delete(vehicleId);
    }

    @GetMapping(path = "/getPackage", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Vehicle> getPackage(@RequestParam("vehicleId") String vehicleId) {
        return vehicleControllerInterface.getVehicle(vehicleId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return vehicleControllerInterface.getAll();
    }

    @GetMapping(path = "/getVehicleByUserName", params = "VehicleBrand")
    public Response getVehicleByUserName(@RequestParam("VehicleBrand") String vehicleBrand){
        return vehicleControllerInterface.getVehicleByUserName(vehicleBrand);
    }
}
