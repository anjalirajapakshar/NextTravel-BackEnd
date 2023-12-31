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
            System.out.println(generateNextUserId());
            hotelDTO.setHotelID(generateNextUserId());

            packagesControllerInterface.getHotelIds(hotelDTO.getHotelID(),hotelDTO.getPackageId());

            hotelRepo.save(modelMapper.map(hotelDTO, Hotel.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully saved!", null);
        }
        throw new RuntimeException("Hotel already exists!");

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

    @Override
    public Response getHotelsByPackageId(String packageId) {
        List<Hotel> hotels = hotelRepo.findHotelByPackageId(packageId);
        System.out.println(hotels);

        if (hotels != null){
            return createAndSendResponse(HttpStatus.OK.value(), "Hotels successfully retreived!", hotels);
        }
        return createAndSendResponse(HttpStatus.OK.value(), "Cannot find Hotels to the given packageId!", null);

    }


    public String generateNextUserId() {
        List<String> lastIds = hotelRepo.getLastId();
        System.out.println(lastIds);

        if (lastIds != null && !lastIds.isEmpty()) {
            String lastId = lastIds.get(0);
            System.out.println(lastId);

            // Check if the last ID matches the expected format "U00X" or "U0X" or "UXX"
            if (lastId.matches("H\\d{1,3}")) {
                return generateNextUserId(lastId);
            }
        }

        return "H001"; // Fallback if the format is not as expected
    }

    private static String generateNextUserId(String currentUserId) {
        if (currentUserId != null && currentUserId.matches("H\\d{1,3}")) {
            int id = Integer.parseInt(currentUserId.replace("H", ""));
            id += 1;
            return "H" + String.format("%03d", id);
        }
        return "H001"; // Fallback if the format is not as expected
    }
}
