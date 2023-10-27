package com.anjali.hs.dto;

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
public class HotelDTO implements Serializable,SuperDTO{

    @Valid
    private String hotelID;

    @NotNull(message = "hotelName cannot be null")
    @NotBlank(message = "hotelName cannot be blank")
    private String hotelName;

    @NotNull(message = "hotelCatageory cannot be null")
    @NotBlank(message = "hotelCatageory cannot be blank")
    private String hotelCatageory;

    @NotNull(message = "hotelLocation cannot be null")
    @NotBlank(message = "hotelLocation cannot be blank")
    private String hotelLocation;

    @NotNull(message = "hotelLocationWithCoordinates cannot be null")
    @NotBlank(message = "hotelLocationWithCoordinates cannot be blank")
    private String hotelLocationWithCoordinates;

    @NotNull(message = "hotelEmail cannot be null")
    @Size(min = 2,max = 50,message = "hotelEmail must be between 2 and 50 characters")
    @NotBlank(message = "hotelEmail cannot be blank")
    private String hotelEmail;

    @NotNull(message = "hotelContactNumber cannot be null")
    @Size(min = 2,max = 10,message = "hotelContactNumber must be between 2 and 10 characters")
    @NotBlank(message = "hotelContactNumber cannot be blank")
    private String hotelContactNumber;

    @NotNull(message = "isPetsAllowed cannot be null")
    @Size(min = 2,max = 3,message = "isPetsAllowed must be between 2 and 3 characters")
    @NotBlank(message = "isPetsAllowed cannot be blank")
    private String isPetsAllowed;

    @Positive(message = "Value cannot be negative")
    private double fullDbl;

    @Positive(message = "Value cannot be negative")
    private double halfDbl;

    @Positive(message = "Value cannot be negative")
    private double fullTpl;

    @Positive(message = "Value cannot be negative")
    private double halfTpl;

    @NotNull(message = "cancellationCriteria cannot be null")
    @Size(min = 2,max = 50,message = "cancellationCriteria must be between 2 and 50 characters")
    @NotBlank(message = "cancellationCriteria cannot be blank")
    private String cancellationCriteria;

    @NotNull(message = "packageId cannot be null")
    @NotBlank(message = "packageId cannot be blank")
    private String packageId;
}
//fullDbl.halfDbl.fullTpl.halfTpl