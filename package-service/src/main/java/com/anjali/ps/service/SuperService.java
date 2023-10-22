package com.anjali.ps.service;


import com.anjali.ps.dto.PackagesDTO;
import com.anjali.ps.dto.SuperDTO;
import com.anjali.ps.dto.VehiclePackageIdDTO;
import com.anjali.ps.entity.Packages;
import com.anjali.ps.response.Response;

import javax.persistence.Id;
import java.util.Optional;

public interface SuperService<T extends SuperDTO,ID >{
    Response save(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    PackagesDTO getPackage(ID id);

    public Response saveVehicleIds(String Vehicleid, String Packageid);

    public Response saveHotelIds(String Hotelid, String Packageid);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);

    Response deleteHotelFromPackage(String hotelID, String packageid);

    Response deleteVehicleFromPackage(String vehicleID, String packageid);

    Response getPackageByUserName(String packageUserName);
}
