package com.anjali.gs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideDTO implements Serializable,SuperDTO{

    @Valid
    @NotNull(message = "GuideId cannot be null")
    @NotBlank(message = "GuideId cannot be blank")
    private String guideId;

    @NotNull(message = "guideName cannot be null")
    @NotBlank(message = "guideName cannot be blank")
    private String guideName;

    @NotNull(message = "guideAddress cannot be null")
    @Size(min = 2,max = 50,message = "guideAddress must be between 2 and 50 characters")
    @NotBlank(message = "guideAddress cannot be blank")
    private String guideAddress;

    @NotNull(message = "guideAge cannot be null")
    @Min(value = 1, message = "guideAge must be at least 1")
    @Max(value = 100, message = "guideAge cannot be greater than 2")
    private int guideAge;

    @NotNull(message = "gender cannot be null")
    @Size(min = 4,max = 10,message = "gender must be between 4 and 5 characters")
    @NotBlank(message = "gender cannot be blank")
    private String gender;

    @NotNull(message = "guideContact cannot be null")
    @NotBlank(message = "guideContact cannot be blank")
    private String guideContact;

    @NotNull(message = "guideImageLocation cannot be null")
    @NotBlank(message = "guideImageLocation cannot be blank")
    private String guideImageLocation;

    @NotNull(message = "guideNICImageLocation cannot be null")
    @NotBlank(message = "guideNICImageLocation cannot be blank")
    private String guideNICImageLocation;

    @NotNull(message = "guideIDImageLocation cannot be null")
    @NotBlank(message = "guideIDImageLocation cannot be blank")
    private String guideIDImageLocation;

    @NotNull(message = "guideExperience cannot be null")
    @NotBlank(message = "guideExperience cannot be blank")
    private String guideExperience;

    @NotNull(message = "manDayValue cannot be null")
    @NotBlank(message = "manDayValue cannot be blank")
    private String manDayValue;
}
