package com.anjali.ps.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "USER-AUTH-SERVICE")
public interface UserDetailsControllerInterface {
    @PutMapping( value = "/getPaymentId",params = {"paymentID","userID"})
    public void getPaymentIds(@RequestParam("paymentID") String PaymentID, @RequestParam("userID") String UserID);
}
