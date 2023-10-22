package com.anjali.pds.service.custom.Impl;

import com.anjali.pds.dto.*;
import com.anjali.pds.entity.PackageDetail;
import com.anjali.pds.interfaces.*;
import com.anjali.pds.repo.PackageDetailRepo;
import com.anjali.pds.response.Response;
import com.anjali.pds.service.custom.PackageDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PackageDetailServiceImpl implements PackageDetailService {
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PackageDetailRepo packageDetailRepo;

    @Autowired
    private GuideControllerInterface guideControllerInterface;

    @Autowired
    private HotelControllerInterface hotelControllerInterface;

    @Autowired
    private PackageControllerInterface packageControllerInterface;

    @Autowired
    private UserControllerInterface userControllerInterface;

    @Autowired
    private VehicleControllerInterface vehicleControllerInterface;


    @Override
    public Response save(PackageDetailDTO packageDetailDTO) {
        if (search(packageDetailDTO.getPackageDetailId()).getData() == null) {

//            userControllerInterface.getPackageDetailIds(packageDetailDTO.getPackageDetailId(),packageDetailDTO.getUserId());

            packageDetailRepo.save(modelMapper.map(packageDetailDTO, PackageDetail.class));
            return createAndSendResponse(HttpStatus.OK.value(), "PackageDetail Successfully saved!", null);
        }
        throw new RuntimeException("PackageDetail does not exists!");
    }

    @Override
    public Response update(PackageDetailDTO packageDetailDTO) {
        if (search(packageDetailDTO.getPackageDetailId()).getData() != null) {
            packageDetailRepo.save(modelMapper.map(packageDetailDTO, PackageDetail.class));
            return createAndSendResponse(HttpStatus.OK.value(), "PackageDetail Successfully updated!", null);
        }
        throw new RuntimeException("PackageDetail does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            packageDetailRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "PackageDetail Successfully deleted!", null);
        }
        throw new RuntimeException("PackageDetail does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<PackageDetail> packageDetail = packageDetailRepo.findById(s);
        if (packageDetail.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "PackageDetail Successfully retrieved!", modelMapper.map(packageDetail.get(), PackageDetailDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "PackageDetail does not exists!", null);
    }

    @Override
    public PackageDetailDTO getPackageDetail(String s) {
        Optional<PackageDetail> packageDetail = packageDetailRepo.findById(s);

        if (packageDetail.isPresent()) {
            System.out.println(packageDetail.get());
            return modelMapper.map(packageDetail.get(), PackageDetailDTO.class);
        }
        throw new RuntimeException("packagedetail cannot found!!!");
    }


    @Override
    public Response getAll() {
        List<PackageDetail> packageDetail = packageDetailRepo.findAll();
        if (!packageDetail.isEmpty()) {
            ArrayList<PackageDetailDTO> packageDetails_dtos = new ArrayList<>();
            packageDetail.forEach((packageDetailsss) -> {
                packageDetails_dtos.add(modelMapper.map(packageDetailsss, PackageDetailDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "PackageDetails Successfully retrieved!", packageDetails_dtos);
        }
        throw new RuntimeException("No PackageDetails found in the database!");
    }

    @Override
    public Response deletePackageDetails(String userId) {
        System.out.println(userId);

        List<PackageDetail> packageDetails = packageDetailRepo.findAll();
        if (!packageDetails.isEmpty()) {
            for (int i = 0; i < packageDetails.size(); i++) {
                System.out.println(packageDetails.get(i).getUserId() +"========"+userId );
                if (Objects.equals(packageDetails.get(i).getUserId(), userId)){
                    System.out.println(packageDetails.get(i).getPackageDetailId());
                    packageDetailRepo.deleteById(packageDetails.get(i).getPackageDetailId());
                    return createAndSendResponse(HttpStatus.OK.value(), "PackageDetail "+packageDetails.get(i).getPackageDetailId()+" deleted!", null);
                }
            }
            return createAndSendResponse(HttpStatus.OK.value(), "ooppsss!", null);

        }
        throw new RuntimeException("No Payments found in the database!");

    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    @Override
    public PackageDetailDTO getPackageDetailByUserName(String packageDetailName) {
        PackageDetail packageDetail = packageDetailRepo.findPackageDetailByUsername(packageDetailName);
        System.out.println(packageDetail);

        PackageDetailDTO packageDetailDTO = modelMapper.map(packageDetail, PackageDetailDTO.class);

        if (packageDetailDTO != null){
            return packageDetailDTO;
        }
        throw new RuntimeException("packageDetail cannot find!!");
    }

    public GuideDTO getGuide(String s){
        Optional<PackageDetail> packageDetail = packageDetailRepo.findById(s);

        if (packageDetail.isPresent()){
            return guideControllerInterface.getGuideDTO(packageDetail.get().getGuideId());
        }

        throw new RuntimeException("Cannot find package detail");
    }

    public HotelDTO getHotel(String s){
        Optional<PackageDetail> packageDetail = packageDetailRepo.findById(s);

        if (packageDetail.isPresent()){
            return hotelControllerInterface.getHotel(packageDetail.get().getHotelId());
        }

        throw new RuntimeException("Cannot find hotel");
    }

    public PackagesDTO getPackage(String s){
        Optional<PackageDetail> packageDetail = packageDetailRepo.findById(s);

        if (packageDetail.isPresent()){
            return packageControllerInterface.getPackage(packageDetail.get().getPackageId());
        }

        throw new RuntimeException("Cannot find package");
    }

    public UserDetailsDTO getUser(String s){
        Optional<PackageDetail> packageDetail = packageDetailRepo.findById(s);

        if (packageDetail.isPresent()){
            return userControllerInterface.getUserDetail(packageDetail.get().getUserId());
        }

        throw new RuntimeException("Cannot find user");
    }

    public VehicleDTO getVehicle(String s){
        Optional<PackageDetail> packageDetail = packageDetailRepo.findById(s);

        if (packageDetail.isPresent()){
            return vehicleControllerInterface.getVehicle(packageDetail.get().getVehicleId());
        }

        throw new RuntimeException("Cannot find vehicle");
    }
}
