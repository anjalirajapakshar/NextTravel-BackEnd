package com.anjali.pds.interfaces;

import com.anjali.pds.dto.HotelDTO;
import com.anjali.pds.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelControllerInterface {
    @GetMapping(path = "/getHotel")
    public HotelDTO getHotel(@RequestParam("hotelId") String hotelId);

    @GetMapping(path = "/getHotelByUserName", params = "HotelName")
    public Response getHotelByUserName(@RequestParam("HotelName") String hotelName);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();

    @GetMapping(path = "/getHotelsByPackageId", params = "packageId")
    public Response getHotelsByPackageId(@RequestParam("packageId") String packageID);
}
