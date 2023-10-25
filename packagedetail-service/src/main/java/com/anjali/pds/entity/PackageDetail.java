package com.anjali.pds.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PackageDetail {
    @Id
    private String packageDetailId;
    private String packageCategory;
    private int travelDuration; //int
    private String travelArea;
    private int noOfAdults;
    private int noOfChildren;
    private int totalHeadCount;
    private String withPetsOrNot;
    private String isGuideIncluded;
    private double packageValue;

    private String vehicleId;
    private String hotelId;
    private String guideId;
    private String packageId;
    private String userId;



}
