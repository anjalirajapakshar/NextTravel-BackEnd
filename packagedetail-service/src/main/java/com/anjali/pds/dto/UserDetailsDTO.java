package com.anjali.pds.dto;

import com.anjali.pds.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsDTO implements SuperDTO{
    private String userId;
    private String userName;
    private String pw;
    @Enumerated
    private Roles role;
    private String userNIC;
    private String userAddress;
    private String userDOB;
    private String userPhone;
    private String userEmail;
    private String gender;
    private String userNICimageLocation;
    private String userImageLocation;

}
