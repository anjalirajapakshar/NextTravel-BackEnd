package com.anjali.hs.service.custom.Impl;

import com.anjali.hs.dto.HotelDTO;
import com.anjali.hs.entity.Hotel;
import com.anjali.hs.interfaces.PackagesControllerInterface;
import com.anjali.hs.repo.HotelRepo;
import com.anjali.hs.response.Response;
import com.anjali.hs.service.custom.HotelService;
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
public class HotelServiceImpl implements HotelService {
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private PackagesControllerInterface packagesControllerInterface;

    @Override
    public Response saveHotel(HotelDTO hotelDTO) {

        if (search(hotelDTO.getHotelID()).getData() == null) {
            System.out.println(generateNextAppointmentId());
            hotelDTO.setHotelID(generateNextAppointmentId());

            packagesControllerInterface.getHotelIds(hotelDTO.getHotelID(),hotelDTO.getPackageId());

            hotelRepo.save(modelMapper.map(hotelDTO, Hotel.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully saved!", null);
        }
        throw new RuntimeException("Hotel already exists!");
//        if (search(hotelDTO.getHotelID()).getData() == null) {
//
//            Optional<Packages> packages = packagesControllerInterface.getPackage(hotelDTO.getPackageId());
//
//            if(packages.isPresent()){
//                String packageId = packages.get().getPackageId();
//                String packageCategory = packages.get().getPackageCategory();
//                String hotelCategory = packages.get().getHotelCategory();
//                String vehicleCategory = packages.get().getVehicleCategory();
//
//                Packages packages1 = new Packages(packageId, packageCategory,vehicleCategory, hotelCategory ,new ArrayList<>(),new ArrayList<>());
//
//                Hotel hotel = modelMapper.map(hotelDTO, Hotel.class);
//                hotel.setPackageId(packages1);
//                System.out.println(hotel);
//                hotelRepo.save(hotel);
//                return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully saved!", null);
//
//            }
//
//        }
//        throw new RuntimeException("Hotel already exists!");
    }

    @Override
    public Response update(HotelDTO hotelDTO) {
        if (search(hotelDTO.getHotelID()).getData() != null) {
            hotelRepo.save(modelMapper.map(hotelDTO, Hotel.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully updated!", null);
        }
        throw new RuntimeException("Hotel does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {

            Optional<Hotel> hotel = hotelRepo.findById(s);
            packagesControllerInterface.getHotelIdsForDeleteHotel(hotel.get().getHotelID(),hotel.get().getPackageId());

            hotelRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully deleted!", null);
        }
        throw new RuntimeException("Hotel does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<Hotel> hotel = hotelRepo.findById(s);
        if (hotel.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Hotel Successfully retrieved!", modelMapper.map(hotel.get(), HotelDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel does not exists!", null);
    }

    @Override
    public Response getAll() {
        List<Hotel> hotels = hotelRepo.findAll();
        if (!hotels.isEmpty()) {
            ArrayList<HotelDTO> hotels_dtos = new ArrayList<>();
            hotels.forEach((hotelss) -> {
                hotels_dtos.add(modelMapper.map(hotelss, HotelDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Hotels Successfully retrieved!", hotels_dtos);
        }
        throw new RuntimeException("No Hotels found in the database!");
    }

    @Override
    public HotelDTO getHotel(String s) {
        Optional<Hotel> hotel = hotelRepo.findById(s);

        if (hotel.isPresent()) {
            System.out.println(hotel.get());
            return modelMapper.map(hotel.get(), HotelDTO.class);
        }
        throw new RuntimeException("hotel cannot found!!!");
    }

    @Override
    public Response deleteHotels(List<String> hotelIds) {
        System.out.println(hotelIds);
        for (String hotelId : hotelIds) {
            hotelRepo.deleteById(hotelId);
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel "+hotelIds+" deleted!", null);
        }
        return createAndSendResponse(HttpStatus.OK.value(), "ooppsss!", null);
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    @Override
    public Response getHotelByUserName(String hotelUserName) {
        Hotel hotel = hotelRepo.findHotelByUsername(hotelUserName);
        System.out.println(hotel);

        HotelDTO hotelDTO = modelMapper.map(hotel, HotelDTO.class);

        if (hotelDTO != null){
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel successfully retreived deleted!", hotelDTO);
        }
        throw new RuntimeException("Hotel cannot find!!");
    }

    public String generateNextAppointmentId(){
        List<String> lastIds = hotelRepo.getLastId();
        System.out.println(lastIds);

        String lastId = lastIds.get(0);
        System.out.println(lastId);

        if (lastId != null){
            return generateNextAppointmentId(lastId);
        }
        return "Cannot get last hotel id";

    }

    private static String generateNextAppointmentId(String CurrentAppId){
        if(CurrentAppId != null){
            String[] split = CurrentAppId.split("H00");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "H00" + id;
        }
        return "H001";
    }
}
