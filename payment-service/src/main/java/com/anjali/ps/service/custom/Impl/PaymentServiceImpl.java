package com.anjali.ps.service.custom.Impl;

import com.anjali.ps.dto.PaymentDTO;
import com.anjali.ps.entity.Payment;
import com.anjali.ps.interfaces.UserDetailsControllerInterface;
import com.anjali.ps.repo.PaymentRepo;
import com.anjali.ps.response.Response;
import com.anjali.ps.service.custom.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private UserDetailsControllerInterface userDetailsControllerInterface;

    @Override
    public Response savePayment(PaymentDTO paymentDTO) {
        if (search(paymentDTO.getPaymentId()).getData() == null) {
            System.out.println(paymentDTO);
            System.out.println(generateNextAppointmentId());
            paymentDTO.setPaymentId(generateNextAppointmentId());
//            userDetailsControllerInterface.getPaymentIds(paymentDTO.getPaymentId(),paymentDTO.getUserId());

            paymentRepo.save(modelMapper.map(paymentDTO, Payment.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Payment Successfully saved!", null);
        }
        throw new RuntimeException("Payment already exists!");
    }

    @Override
    public Response update(PaymentDTO paymentDTO) {
        if (search(paymentDTO.getPaymentId()).getData() != null) {
            paymentRepo.save(modelMapper.map(paymentDTO, Payment.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Payment Successfully updated!", null);
        }
        throw new RuntimeException("Payment does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            paymentRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "Payment Successfully deleted!", null);
        }
        throw new RuntimeException("Payment does not exists!");
    }

    @Override
    public Response search(String s) {
            Optional<Payment> payment = paymentRepo.findById(s);
            if (payment.isPresent()) {
                return createAndSendResponse(HttpStatus.FOUND.value(), "Payment Successfully retrieved!", modelMapper.map(payment.get(), PaymentDTO.class));
            }
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Payment does not exists!", null);
    }

    @Override
    public PaymentDTO getPayment(String s) {
        Optional<Payment> payment = paymentRepo.findById(s);

        if (payment.isPresent()) {
            System.out.println(payment.get());
            return modelMapper.map(payment.get(), PaymentDTO.class);
        }
        throw new RuntimeException("payment cannot found!!!");
    }


    @Override
    public Response getAll() {
            List<Payment> payment = paymentRepo.findAll();
            if (!payment.isEmpty()) {
                ArrayList<PaymentDTO> payments_dtos = new ArrayList<>();
                payment.forEach((paymentss) -> {
                    payments_dtos.add(modelMapper.map(paymentss, PaymentDTO.class));
                });
                return createAndSendResponse(HttpStatus.FOUND.value(), "Payments Successfully retrieved!", payments_dtos);
            }
            throw new RuntimeException("No Payments found in the database!");
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    @Override
    public Response deletePayments(String userId) {
        System.out.println(userId);

        List<Payment> payments = paymentRepo.findAll();
        List<String> deletedIds = new ArrayList<>();
        if (!payments.isEmpty()) {
            for (int i = 0; i < payments.size(); i++) {
                System.out.println(payments.get(i).getUserId() +"========"+userId );
                if (Objects.equals(payments.get(i).getUserId(), userId)){
                    System.out.println(payments.get(i).getPaymentId());
                    paymentRepo.deleteById(payments.get(i).getPaymentId());
                    deletedIds.add(payments.get(i).getPaymentId());
                }
            }
            if (!deletedIds.isEmpty()) {
                // At least one item was deleted
                return createAndSendResponse(HttpStatus.OK.value(), "payments " + deletedIds + " deleted!", null);
            } else {
                // No matching items were found
                return createAndSendResponse(HttpStatus.OK.value(), "No matching payments found!", null);
            }
        }
        return createAndSendResponse(HttpStatus.OK.value(), "no payments for this userid!", null);


    }

    public String generateNextAppointmentId(){
        List<String> lastIds = paymentRepo.getLastId();
        System.out.println(lastIds);

        String lastId = lastIds.get(0);
        System.out.println(lastId);

        if (lastId != null){
            return generateNextAppointmentId(lastId);
        }
        return "PAY001";



//        return "Cannot get last PackageDetail id";

    }

    private static String generateNextAppointmentId(String CurrentAppId){
        if(CurrentAppId != null){
            String[] split = CurrentAppId.split("PAY00");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "PAY00" + id;
        }
        return "PAY001";
    }

}
