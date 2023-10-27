package com.anjali.uas.dto;

import com.anjali.uas.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsDTO implements SuperDTO, Serializable {

    @Valid
    private String userId;

    @NotNull(message = "userName cannot be null")
    @Size(min = 2,max = 20,message = "userName must be between 2 and 20 characters")
    @NotBlank(message = "userName cannot be blank")
    private String userName;

    @NotNull(message = "pw cannot be null")
    @Size(min = 8,max = 20,message = "pw must be between 8 and 20 characters")
    @NotBlank(message = "pw cannot be blank")
    private String pw;

    @NotNull(message = "role cannot be null")
    @Size(min = 2,max = 10,message = "role must be between 2 and 10 characters")
    @NotBlank(message = "role cannot be blank")
//    @Enumerated(EnumType.STRING)
    private String role;

    @NotNull(message = "userNIC cannot be null")
    @Size(min = 10,max = 13,message = "userNIC must be between 10 and 13 characters")
    @NotBlank(message = "userNIC cannot be blank")
    private String userNIC;

    @NotNull(message = "userAddress cannot be null")
    @Size(min = 2,max = 50,message = "userAddress must be between 2 and 50 characters")
    @NotBlank(message = "userAddress cannot be blank")
    private String userAddress;

    @NotNull(message = "userDOB cannot be null")
    @Size(min = 2,max = 10,message = "userDOB must be between 2 and 10 characters")
    @NotBlank(message = "userDOB cannot be blank")
    private String userDOB;

    @NotNull(message = "userPhone cannot be null")
    @Size(min = 10,max = 10,message = "userPhone must be between 10 and 10 characters")
    @NotBlank(message = "userPhone cannot be blank")
    private String userPhone;

    @NotNull(message = "userEmail cannot be null")
    @Size(min = 2,max = 50,message = "userEmail must be between 2 and 50 characters")
    @NotBlank(message = "userEmail cannot be blank")
    private String userEmail;

    @NotNull(message = "gender cannot be null")
    @Size(min = 4,max = 5,message = "gender must be between 4 and 5 characters")
    @NotBlank(message = "gender cannot be blank")
    private String gender;

    @NotNull(message = "userNICimageLocation cannot be null")
    @Size(min = 2,max = 50,message = "userNICimageLocation must be between 2 and 50 characters")
    @NotBlank(message = "userNICimageLocation cannot be blank")
    private String userNICimageLocation;

    @NotNull(message = "userImageLocation cannot be null")
    @Size(min = 2,max = 50,message = "userImageLocation must be between 2 and 50 characters")
    @NotBlank(message = "userImageLocation cannot be blank")
    private String userImageLocation;

//    @AssertTrue(message = "The booleanValue must be true")
    private boolean isValidated;
}
