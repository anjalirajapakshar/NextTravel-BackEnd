package com.anjali.uas.endpoints;


import com.anjali.uas.dto.UserDetailsDTO;
import com.anjali.uas.model.UserDetails;
import com.anjali.uas.response.Response;
import com.anjali.uas.service.UserDetailsServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin

public class AuthController {
    @Autowired
    private Response response;

    @Autowired
    private UserDetailsServicee userDetailsServicee;
    @PostMapping(path = "/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response register(@Valid @RequestBody UserDetailsDTO userDetails){
        userDetailsServicee.save(userDetails);
        return response;
    }


}
