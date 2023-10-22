package com.anjali.gs.service;


import com.anjali.gs.dto.GuideDTO;
import com.anjali.gs.response.Response;

public interface SuperService<T extends GuideDTO,ID >{
    Response save(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    GuideDTO getGuide(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);

    Response getGuideByUserName(String guideUserName);
}
