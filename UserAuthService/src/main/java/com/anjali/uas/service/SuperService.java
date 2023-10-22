package com.anjali.uas.service;


import com.anjali.uas.dto.UserDetailsDTO;
import com.anjali.uas.response.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService<T extends UserDetailsDTO,ID >{
    Response save(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    UserDetailsDTO getUserDetails(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);

    Response savePaymentIds(String paymentId, String userID);

    Response savePackageDetailIds(String packageDetailId, String userId);

    Response getUserDetailByUserName(String UserName);

    Response validateAndGetUser(String username,String password);
}
