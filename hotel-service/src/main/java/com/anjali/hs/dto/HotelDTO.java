package com.anjali.hs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO implements Serializable,SuperDTO{
    private String hotelID;
    private String hotelName;
    private String hotelCatageory;
    private String hotelLocation;
    private String hotelEmail;
    private String hotelContactNumber;
    private String isPetsAllowed;

    private double fullDbl;
    private double halfDbl;
    private double fullTpl;
    private double halfTpl;
    private String cancellationCriteria;

    private String packageId;
}
//fullDbl.halfDbl.fullTpl.halfTpl