package com.anjali.uas.service;

import com.anjali.uas.dto.UserDetailsDTO;

public interface UserDetailsServicee extends SuperService<UserDetailsDTO,String> {
    boolean passwordValidator(String  enteredPassword,String storedPassword);

}
