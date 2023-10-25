package com.anjali.uas.dto;

import com.anjali.uas.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsDTO implements SuperDTO, Serializable {
    private String userId;
    private String userName;
    private String pw;
//    @Enumerated(EnumType.STRING)
    private String role;
    private String userNIC;
    private String userAddress;
    private String userDOB;
    private String userPhone;
    private String userEmail;
    private String gender;
    private String userNICimageLocation;
    private String userImageLocation;
    private boolean isValidated;
}
