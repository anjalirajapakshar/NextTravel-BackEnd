package com.anjali.vs.service;



import com.anjali.vs.dto.SuperDTO;
import com.anjali.vs.dto.VehicleDTO;
import com.anjali.vs.entity.Vehicle;
import com.anjali.vs.response.Response;

import java.util.List;
import java.util.Optional;

public interface SuperService<T extends SuperDTO,ID >{
    Response saveVehicle(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    VehicleDTO getVehicle(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);

    Response deleteVehicles(List<String> vehicleIds);

    Response getVehicleByUserName(String vehicleBrand);
}
