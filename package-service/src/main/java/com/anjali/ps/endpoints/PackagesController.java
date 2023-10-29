package com.anjali.ps.endpoints;

import com.anjali.ps.dto.PackagesDTO;
import com.anjali.ps.entity.Packages;
import com.anjali.ps.response.Response;
import com.anjali.ps.service.custom.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("")
@CrossOrigin
public class PackagesController {
    @Autowired
    private PackageService packageService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response save( @RequestBody PackagesDTO packagesDTO) {
        return packageService.save(packagesDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update( @RequestBody PackagesDTO packagesDTO) {
        return packageService.update(packagesDTO);
    }

    @GetMapping(path = "/search", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("packagesId") String packagesId) {
        return packageService.search(packagesId);
    }

    @DeleteMapping(path = "/delete", params = "packagesId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("packagesId") String packagesId) {
        return packageService.delete(packagesId);
    }

    @PutMapping( value = "/getVehicleId",params = {"vehicleID","packageID"})
    public Response getVehicleIds(@RequestParam("vehicleID") String Vehicleid, @RequestParam("packageID") String Packageid){
        return packageService.saveVehicleIds(Vehicleid,Packageid);
    }

    @PutMapping( value = "/getHotelId",params = {"hotelID","packageID"})
    public Response getHotelIds(@RequestParam("hotelID") String HotelID, @RequestParam("packageID") String Packageid){
        return packageService.saveHotelIds(HotelID,Packageid);
    }

    @GetMapping(path = "/getPackage", params = "packagesId")
    public PackagesDTO getPackage(@RequestParam("packagesId") String packagesId) {
        return packageService.getPackage(packagesId);
    }

    @PutMapping( value = "/getHotelIdsForDelete",params = {"hotelID","packageID"})
    public Response getHotelIdsForDeleteHotel(@RequestParam("hotelID") String HotelID, @RequestParam("packageID") String Packageid){
        return packageService.deleteHotelFromPackage(HotelID,Packageid);
    }

    @PutMapping( value = "/getVehicleIdsForDelete",params = {"vehicleID","packageID"})
    public Response getVehicleIdsForDeleteHotel(@RequestParam("vehicleID") String VehicleID, @RequestParam("packageID") String Packageid){
        return packageService.deleteVehicleFromPackage(VehicleID,Packageid);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return packageService.getAll();
    }

    @GetMapping(path = "/getPackageByUserName", params = "PackageName")
    public Response getPackageByUserName(@RequestParam("PackageName") String packageName){
        return packageService.getPackageByUserName(packageName);
    }
}
