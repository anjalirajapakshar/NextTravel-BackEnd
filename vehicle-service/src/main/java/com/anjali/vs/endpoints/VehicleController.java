package com.anjali.vs.endpoints;

import com.anjali.vs.dto.VehicleDTO;
import com.anjali.vs.entity.Vehicle;
import com.anjali.vs.interfaces.PackagesControllerInterface;
import com.anjali.vs.repo.VehicleRepo;
import com.anjali.vs.response.Response;
import com.anjali.vs.service.custom.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:8081")
public class VehicleController {
    @Autowired
    private Response response;

    @Autowired
    private VehicleService vehicleService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.saveVehicle(vehicleDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.update(vehicleDTO);
    }

    @GetMapping(path = "/search", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("vehicleId") String vehicleId) {
        return vehicleService.search(vehicleId);
    }

    @DeleteMapping(path = "/delete", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("vehicleId") String vehicleId) {
        return vehicleService.delete(vehicleId);
    }

    @GetMapping(path = "/getVehicle")
    public VehicleDTO getVehicle(@RequestParam("vehicleId") String vehicleId) {
        return vehicleService.getVehicle(vehicleId);
    }

    @PutMapping( value = "/getVehicleIds")
    public Response getVehicleIds(@RequestBody List<String> VehicleIds){
        return vehicleService.deleteVehicles(VehicleIds);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return vehicleService.getAll();
    }

    @GetMapping(path = "/getVehicleByUserName", params = "VehicleBrand")
    public Response getVehicleByUserName(@RequestParam("VehicleBrand") String vehicleBrand){
        return vehicleService.getVehicleByUserName(vehicleBrand);
    }

}
