package com.anjali.uas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    private String paymentId;
    private String paymentDate;
    private String paymentAmount;
    private String userId;
    private String packageDetailsId;
}
