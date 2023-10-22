package com.anjali.uas.interfaces;

import com.anjali.uas.dto.PaymentDTO;
import com.anjali.uas.model.Payment;
import com.anjali.uas.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentControllerInterface {
    @PostMapping(path = "/sp", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response savePayment(@RequestBody PaymentDTO paymentDTO);

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PaymentDTO paymentDTO);

    @GetMapping(path = "/search", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("paymentId") String paymentId);

    @DeleteMapping(path = "/delete", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("paymentId") String paymentId);

    @GetMapping(path = "/getPayment", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Payment> getPayment(@RequestParam("paymentId") String paymentId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();

    @PutMapping( value = "/getUserId")
    public void getUserId(@RequestBody String UserId);


}
