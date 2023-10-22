package com.anjali.uas.interfaces;

import com.anjali.uas.dto.PackagesDTO;
import com.anjali.uas.model.Packages;
import com.anjali.uas.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "PACKAGE-SERVICE")
public interface PackagesControllerInterface {
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody PackagesDTO packagesDTO);

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackagesDTO packagesDTO);

    @GetMapping(path = "/search", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("packagesId") String packagesId);

    @DeleteMapping(path = "/delete", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("packagesId") String packagesId);

    @GetMapping(path = "/getPackage", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Packages> getPackage(@RequestParam("packagesId") String packagesId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();

    @GetMapping(path = "/getPackageByUserName", params = "PackageName")
    public Response getPackageByUserName(@RequestParam("PackageName") String packageName);

    @PutMapping( value = "/getVehicleId",params = {"vehicleID","packageID"})
    public Response getVehicleIds(@RequestParam("vehicleID") String Vehicleid, @RequestParam("packageID") String Packageid);
}
