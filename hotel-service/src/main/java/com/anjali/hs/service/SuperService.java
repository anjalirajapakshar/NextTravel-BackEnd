package com.anjali.hs.service;


import com.anjali.hs.dto.HotelDTO;
import com.anjali.hs.response.Response;

import java.util.List;

public interface SuperService<T extends HotelDTO,ID >{
    Response saveHotel(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    Response getAll();

    HotelDTO getHotel(ID id);

    Response deleteHotels(List<String> hotelList);

    Response createAndSendResponse(int statusCode, String message, Object data);

    Response getHotelByUserName(String hotelUserName);


    Response getHotelsByPackageId(String packageId);
}
