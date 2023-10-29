package com.anjali.ps.repo;

import com.anjali.ps.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, String> {

    @Query("SELECT p.paymentId from Payment p order by p.paymentId DESC")
    List<String> getLastId();
}
