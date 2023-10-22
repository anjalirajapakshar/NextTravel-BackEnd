package com.anjali.uas.endpoints;

import com.anjali.uas.dto.HotelDTO;
import com.anjali.uas.interfaces.HotelControllerInterface;
import com.anjali.uas.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hotel")
@CrossOrigin
public class HotelController {

    @Autowired
    private HotelControllerInterface hotelControllerInterface;

    @PostMapping(path = "/sh",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveHotel(@RequestBody HotelDTO hotelDTO){
        return hotelControllerInterface.saveHotel(hotelDTO);
    }

    @PutMapping(path = "/updateHotel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody HotelDTO hotelDTO) {
        return hotelControllerInterface.update(hotelDTO);
    }

    @GetMapping(path = "/searchHotel", params = "hotelId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("hotelId") String hotelId) {
        return hotelControllerInterface.search(hotelId);
    }

    @DeleteMapping(path = "/deleteHotel", params = "hotelId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("hotelId") String hotelId) {
        return hotelControllerInterface.delete(hotelId);
    }

    @GetMapping(path = "/fetchAllHotel", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return hotelControllerInterface.getAll();
    }

    @GetMapping(path = "/getHotelByUserName", params = "HotelName")
    public Response getHotelByUserName(@RequestParam("HotelName") String hotelName){
        return hotelControllerInterface.getHotelByUserName(hotelName);
    }
}
