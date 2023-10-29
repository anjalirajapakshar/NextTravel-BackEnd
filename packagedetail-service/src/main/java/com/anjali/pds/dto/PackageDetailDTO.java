package com.anjali.pds.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageDetailDTO implements SuperDTO, Serializable {

    @Valid
    private String packageDetailId;

    @NotNull(message = "packageCategory cannot be null")
    @Size(min = 2,max = 20,message = "packageCategory must be between 2 and 20 characters")
    @NotBlank(message = "packageCategory cannot be blank")
    private String packageCategory;

    @NotNull(message = "travelDuration cannot be null")
    @Min(value = 1, message = "travelDuration must be at least 1")
    @Max(value = 100, message = "travelDuration cannot be greater than 2")
    private int travelDuration; //int

    @NotNull(message = "travelArea cannot be null")
    @Size(min = 2,max = 50,message = "travelArea must be between 2 and 50 characters")
    @NotBlank(message = "travelArea cannot be blank")
    private String travelArea;

    @NotNull(message = "noOfAdults cannot be null")
    @Min(value = 1, message = "noOfAdults must be at least 1")
    @Max(value = 100, message = "noOfAdults cannot be greater than 2")
    private int noOfAdults;

    @NotNull(message = "noOfChildren cannot be null")
    @Min(value = 1, message = "noOfChildren must be at least 1")
    @Max(value = 100, message = "noOfChildren cannot be greater than 2")
    private int noOfChildren;

    @NotNull(message = "totalHeadCount cannot be null")
    @Min(value = 1, message = "totalHeadCount must be at least 1")
    @Max(value = 100, message = "totalHeadCount cannot be greater than 2")
    private int totalHeadCount;

    @NotNull(message = "withPetsOrNot cannot be null")
    @Size(min = 2,max = 3,message = "v must be between 2 and 3 characters")
    @NotBlank(message = "withPetsOrNot cannot be blank")
    private String withPetsOrNot;

    @NotNull(message = "isGuideIncluded cannot be null")
    @Size(min = 2,max = 3,message = "isGuideIncluded must be between 2 and 3 characters")
    @NotBlank(message = "isGuideIncluded cannot be blank")
    private String isGuideIncluded;

    @Positive(message = "packageValue cannot be negative")
    private double packageValue;

    @NotNull(message = "vehicleId cannot be null")
    @Size(min = 2,max = 5,message = "vehicleId must be between 2 and 5 characters")
    @NotBlank(message = "vehicleId cannot be blank")
    private String vehicleId;

    @NotNull(message = "hotelId cannot be null")
    @Size(min = 2,max = 5,message = "hotelId must be between 2 and 5 characters")
    @NotBlank(message = "hotelId cannot be blank")
    private String hotelId;

    @NotNull(message = "guideId cannot be null")
    @Size(min = 2,max = 5,message = "guideId must be between 2 and 5 characters")
    @NotBlank(message = "guideId cannot be blank")
    private String guideId;

    @NotNull(message = "packageId cannot be null")
    @Size(min = 2,max = 5,message = "packageId must be between 2 and 5 characters")
    @NotBlank(message = "packageId cannot be blank")
    private String packageId;

    @NotNull(message = "userId cannot be null")
    @Size(min = 2,max = 5,message = "userId must be between 2 and 5 characters")
    @NotBlank(message = "userId cannot be blank")
    private String userId;
}
