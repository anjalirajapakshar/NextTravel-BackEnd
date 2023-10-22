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
public class PackageDetail {
    @Id
    private String packageDetailId;
    private String packageCategory;
    private String travelDuration;
    private String travelArea;
    private int noOfAdults;
    private int noOfChildren;
    private int totalHeadCount;
    private boolean withPetsOrNot;
    private boolean isGuideIncluded;
    private double packageValue;
    private double paidValue;
    private String vehicleId;
    private String hotelId;
    private String guideId;
    private String packageId;
    private String userId;



}
