package com.anjali.ps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackagesDTO implements Serializable,SuperDTO{

    @Valid
    private String packageId;

    @NotNull(message = "packageCategory cannot be null")
    @Size(min = 2,max = 50,message = "packageCategory must be between 2 and 50 characters")
    @NotBlank(message = "packageCategory cannot be blank")
    private String packageCategory;

    @NotNull(message = "vehicleCategory cannot be null")
    @Size(min = 2,max = 50,message = "vehicleCategory must be between 2 and 50 characters")
    @NotBlank(message = "vehicleCategory cannot be blank")
    private String vehicleCategory;

    @NotNull(message = "hotelCategory cannot be null")
    @Size(min = 2,max = 50,message = "hotelCategory must be between 2 and 50 characters")
    @NotBlank(message = "hotelCategory cannot be blank")
    private String hotelCategory;
}
