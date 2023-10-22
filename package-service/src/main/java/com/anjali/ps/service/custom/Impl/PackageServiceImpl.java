package com.anjali.ps.service.custom.Impl;

import com.anjali.ps.dto.PackagesDTO;
import com.anjali.ps.dto.VehiclePackageIdDTO;
import com.anjali.ps.entity.Packages;
import com.anjali.ps.interfaces.HotelControllerInterface;
import com.anjali.ps.interfaces.VehicleControllerInterface;
import com.anjali.ps.repo.PackageRepo;
import com.anjali.ps.response.Response;
import com.anjali.ps.service.custom.PackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PackageServiceImpl implements PackageService {
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PackageRepo packageRepo;

    private List<String> vehicleList;
    private List<String> hotelList;

    @Autowired
    private VehicleControllerInterface vehicleControllerInterface;

    @Autowired
    private HotelControllerInterface hotelControllerInterface;


    @Override
    public Response save(PackagesDTO packagesDTO) {
        if (search(packagesDTO.getPackageId()).getData() == null) {

            System.out.println(generateNextAppointmentId());
            packagesDTO.setPackageId(generateNextAppointmentId());

            packageRepo.save(modelMapper.map(packagesDTO, Packages.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Package Successfully saved!", null);
        }
        throw new RuntimeException("Package does not exists!");
    }

    @Override
    public Response update(PackagesDTO packagesDTO) {
        if (search(packagesDTO.getPackageId()).getData() != null) {
            packageRepo.save(modelMapper.map(packagesDTO, Packages.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Package Successfully updated!", null);
        }
        throw new RuntimeException("Package does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            System.out.println(search(s).getData());

            Optional<Packages> packages = packageRepo.findById(s);
            System.out.println(packages.get());

//            Packages packages = modelMapper.map(search(s).getData(), Packages.class);
//            System.out.println(packages);
            vehicleControllerInterface.getVehicleIds(packages.get().getVehicleList());
            hotelControllerInterface.getHotelIds(packages.get().getHotelsList());

            packageRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "Package Successfully deleted!", null);
        }
        throw new RuntimeException("Package does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<Packages> packages = packageRepo.findById(s);
        if (packages.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Package Successfully retrieved!", modelMapper.map(packages.get(), PackagesDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exists!", null);
    }

    @Override
    public PackagesDTO getPackage(String s) {
        Optional<Packages> packages = packageRepo.findById(s);

        if (packages.isPresent()) {
            System.out.println(packages.get());
            return modelMapper.map(packages.get(), PackagesDTO.class);
        }
        throw new RuntimeException("package cannot found!!!");
    }


    @Override
    public Response getAll() {
        List<Packages> packages = packageRepo.findAll();
        if (!packages.isEmpty()) {
            ArrayList<PackagesDTO> packages_dtos = new ArrayList<>();
            packages.forEach((packagess) -> {
                packages_dtos.add(modelMapper.map(packagess, PackagesDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Packages Successfully retrieved!", packages_dtos);
        }
        throw new RuntimeException("No Packages found in the database!");
    }


    public Response saveVehicleIds(String Vehicleid, String Packageid){
        System.out.println("ygutfytfyrdtry");
        Optional<Packages> packages = packageRepo.findById(Packageid);
        if(packages.isPresent()){
            System.out.println("yguuuuuuuuuuuuuuuuuuuuuuuuy");
            packages.get().getVehicleList().add(Vehicleid);
            System.out.println(packages);
            System.out.println(packages.get().getVehicleList());
            return createAndSendResponse(HttpStatus.FOUND.value(), "Success!(", null);
        }
        throw new RuntimeException("Package is not found!");


        /*this.vehicleList.add(Vehicleid);
        if(packages.isPresent()){
            packages.get().setVehicleList(this.vehicleList);
            return createAndSendResponse(HttpStatus.FOUND.value(), "Success!", null);
        }*/
//        packages.ifPresent(value -> value.setVehicleList(vehicleList));

    }

    @Override
    public Response saveHotelIds(String Hotelid, String Packageid) {
        System.out.println("ygutfytfyrdtry");
        Optional<Packages> packages = packageRepo.findById(Packageid);
        if(packages.isPresent()){
            System.out.println("yguuuuuuuuuuuuuuuuuuuuuuuuy");
            packages.get().getHotelsList().add(Hotelid);
            System.out.println(packages.get());
            System.out.println(packages.get().getHotelsList());
            return createAndSendResponse(HttpStatus.FOUND.value(), "Success!(", null);
        }
        throw new RuntimeException("Package is not found!");
    }


    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    @Override
    public Response deleteHotelFromPackage(String hotelID, String packageid) {
        Optional<Packages> packages = packageRepo.findById(packageid);
        boolean remove = packages.get().getHotelsList().remove(hotelID);
        System.out.println(remove);
        if (remove == true){
            return createAndSendResponse(HttpStatus.FOUND.value(), "Successfully removed HotelId!", null);
        }
        return createAndSendResponse(HttpStatus.FOUND.value(), "cannot remove HotelId!;(", null);
    }

    @Override
    public Response deleteVehicleFromPackage(String vehicleID, String packageid) {
        Optional<Packages> packages = packageRepo.findById(packageid);
        boolean remove = packages.get().getVehicleList().remove(vehicleID);
        System.out.println(remove);
        if (remove == true){
            return createAndSendResponse(HttpStatus.FOUND.value(), "Successfully removed VehicleId!", null);
        }
        return createAndSendResponse(HttpStatus.FOUND.value(), "cannot remove VehicleId!;(", null);
    }

    @Override
    public Response getPackageByUserName(String packageUserName) {
        Packages packages = packageRepo.findPackageByUsername(packageUserName);
        System.out.println(packages);

        PackagesDTO packagesDTO = modelMapper.map(packages, PackagesDTO.class);

        if (packagesDTO != null){
            return createAndSendResponse(HttpStatus.OK.value(), "Successfully Retrived Vehicle!", packagesDTO);
        }
        throw new RuntimeException("Package cannot find!!");
    }

    public String generateNextAppointmentId(){
        List<String> lastIds = packageRepo.getLastId();
        System.out.println(lastIds);

        String lastId = lastIds.get(0);
        System.out.println(lastId);

        if (lastId != null){
            return generateNextAppointmentId(lastId);
        }
        return "Cannot get last package id";

    }

    private static String generateNextAppointmentId(String CurrentAppId){
        if(CurrentAppId != null){
            String[] split = CurrentAppId.split("P00");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "P00" + id;
        }
        return "P001";
    }
}
