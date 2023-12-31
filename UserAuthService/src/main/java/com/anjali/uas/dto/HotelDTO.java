package com.anjali.uas.dto;

import com.anjali.uas.model.Packages;
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
    private String hotelLocationWithCoordinates;
    private String hotelEmail;
    private String hotelContactNumber;
    private boolean isPetsAllowed;
    private int FullBoardDoublehotelFee;
    private int HalfBoardDoublehotelFee;
    private int FullBoardTriplehotelFee;
    private int HalfBoardTriplehotelFee;
    private String cancellationCriteria;

    private String packageId;
}
