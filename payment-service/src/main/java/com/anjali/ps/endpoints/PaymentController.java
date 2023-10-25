package com.anjali.ps.endpoints;

import com.anjali.ps.dto.PaymentDTO;
import com.anjali.ps.entity.Payment;
import com.anjali.ps.response.Response;
import com.anjali.ps.service.custom.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "/sp", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response savePayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.savePayment(paymentDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.update(paymentDTO);
    }

    @GetMapping(path = "/search", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("paymentId") String paymentId) {
        return paymentService.search(paymentId);
    }

    @DeleteMapping(path = "/delete", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("paymentId") String paymentId) {
        return paymentService.delete(paymentId);
    }

    @GetMapping(path = "/getPayment")
    public PaymentDTO getPayment(@RequestParam("paymentId") String paymentId) {
        return paymentService.getPayment(paymentId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return paymentService.getAll();
    }

//    @PutMapping( value = "/getPaymentIds")
//    public Response getPaymentIds(@RequestBody List<String> PaymentIds){
//        return paymentService.deletePayments(PaymentIds);
//    }

    @PutMapping( value = "/getUserId")
    public Response getUserId(@RequestBody String UserId){
        return paymentService.deletePayments(UserId);
    }
}
