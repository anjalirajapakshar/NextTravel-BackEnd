package com.anjali.hs.endpoints;

import com.anjali.hs.dto.HotelDTO;
import com.anjali.hs.response.Response;
import com.anjali.hs.service.custom.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@Valid  @RequestBody HotelDTO hotelDTO){
        return hotelService.saveHotel(hotelDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@Valid @RequestBody HotelDTO hotelDTO) {
        return hotelService.update(hotelDTO);
    }

    @GetMapping(path = "/search", params = "hotelId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("hotelId") String hotelId) {
        return hotelService.search(hotelId);
    }

    @DeleteMapping(path = "/delete", params = "hotelId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("hotelId") String hotelId) {
        return hotelService.delete(hotelId);
    }

    @GetMapping(path = "/getHotel")
    public HotelDTO getHotel(@RequestParam("hotelId") String hotelId) {
        return hotelService.getHotel(hotelId);
    }

    @PutMapping( value = "/getHotelIds")
    public Response getHotelIds(@RequestBody List<String> HotelIds){
        return hotelService.deleteHotels(HotelIds);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return hotelService.getAll();
    }

    @GetMapping(path = "/getHotelByUserName", params = "HotelName")
    public Response getHotelByUserName(@RequestParam("HotelName") String hotelName){
        return hotelService.getHotelByUserName(hotelName);
    }

    @GetMapping(path = "/getHotelsByPackageId", params = "packageId")
    public Response getHotelsByPackageId(@RequestParam("packageId") String packageID){
        return hotelService.getHotelsByPackageId(packageID);
    }


}

//{
//        "hotelID": "H001",
//        "hotelName": "Blue Water Hotel",
//        "hotelCatageory": "5-star",
//        "hotelLocation": " Wadduwa",
//        "hotelLocationWithCoordinates": "12.3456, 78.9012",
//        "hotelEmail": "BlueWater@example.com",
//        "hotelContactNumber": "0116754560",
//        "isPetsAllowed": true,
//        "FullBoardDoublehotelFee": 60000.00,
//        "HalfBoardDoublehotelFee": 40000.00,
//        "FullBoardTriplehotelFee": 80000.00,
//        "HalfBoardTriplehotelFee": 75000.00,
//        "cancellationCriteria": "Free cancellation up to 48 hours before check-in",
//        "packageId": "P004"
//}

