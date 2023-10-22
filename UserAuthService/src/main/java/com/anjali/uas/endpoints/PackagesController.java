package com.anjali.uas.endpoints;

import com.anjali.uas.dto.PackagesDTO;
import com.anjali.uas.interfaces.PackagesControllerInterface;
import com.anjali.uas.model.Packages;
import com.anjali.uas.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/packages")
@CrossOrigin
public class PackagesController {
    @Autowired
    private PackagesControllerInterface packagesControllerInterface;

    @PostMapping(path = "/savePackage", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody PackagesDTO packagesDTO) {
        return packagesControllerInterface.save(packagesDTO);
    }

    @PutMapping(path = "/updatePackage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackagesDTO packagesDTO) {
        return packagesControllerInterface.update(packagesDTO);
    }

    @GetMapping(path = "/searchPackage", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("packagesId") String packagesId) {
        return packagesControllerInterface.search(packagesId);
    }

    @DeleteMapping(path = "/deletePackage", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("packagesId") String packagesId) {
        return packagesControllerInterface.delete(packagesId);
    }

    @GetMapping(path = "/getPackage", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Packages> getPackage(@RequestParam("packagesId") String packagesId) {
        return packagesControllerInterface.getPackage(packagesId);
    }

    @GetMapping(path = "/fetchAllPackages", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return packagesControllerInterface.getAll();
    }

    @GetMapping(path = "/getPackageByUserName", params = "PackageName")
    public Response getPackageByUserName(@RequestParam("PackageName") String packageName){
        return packagesControllerInterface.getPackageByUserName(packageName);
    }

    @PutMapping( value = "/getVehicleId",params = {"vehicleID","packageID"})
    public Response getVehicleIds(@RequestParam("vehicleID") String Vehicleid, @RequestParam("packageID") String Packageid){
        return packagesControllerInterface.getVehicleIds(Vehicleid,Packageid);
    }
}
