package com.anjali.ps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO implements SuperDTO, Serializable {

    @Valid
    private String paymentId;

    @NotNull(message = "paymentDate cannot be null")
    @Size(min = 2,max = 10,message = "paymentDate must be between 2 and 10 characters")
    @NotBlank(message = "paymentDate cannot be blank")
    private String paymentDate;

    @Positive(message = "paymentAmount Value cannot be negative")
    private double paymentAmount;

    @NotNull(message = "userId cannot be null")
    @Size(min = 2,max = 5,message = "userId must be between 2 and 5 characters")
    @NotBlank(message = "userId cannot be blank")
    private String userId;

    @NotNull(message = "packageDetailsId cannot be null")
    @Size(min = 2,max = 5,message = "packageDetailsId must be between 2 and 5 characters")
    @NotBlank(message = "packageDetailsId cannot be blank")
    private String packageDetailsId;
}
