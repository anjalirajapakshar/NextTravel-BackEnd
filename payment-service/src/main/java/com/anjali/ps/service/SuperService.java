package com.anjali.ps.service;


import com.anjali.ps.dto.PaymentDTO;
import com.anjali.ps.dto.SuperDTO;
import com.anjali.ps.entity.Payment;
import com.anjali.ps.response.Response;

import java.util.List;
import java.util.Optional;

public interface SuperService<T extends SuperDTO,ID >{
    Response savePayment(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    PaymentDTO getPayment(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);

    Response deletePayments(String userId);
}
