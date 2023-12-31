package com.anjali.uas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    @Id
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
