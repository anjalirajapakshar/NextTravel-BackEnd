//package com.anjali.uas.service;
//
//
//import com.anjali.uas.model.UserDetails;
//import com.anjali.uas.repo.UserRepo;
//import com.anjali.uas.response.Response;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//    @Autowired
//    private ModelMapper modelMapper;
//    @Autowired
//    private Response response;
//    @Autowired
//    private UserRepo userRepo;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
////    @Autowired
//    private JWTService jwtService;

//    public Response register(UserDetails userDetails) {
//        String password = passwordEncoder.encode(userDetails.getPassword());
//        userDetails.setPw(password);
//        userRepo.save(userDetails);
//
//        HashMap<String,Object> userRoles= new HashMap<>();
//        userRoles.put("userRole",userDetails.getRole());
//        return createAndSendResponse(HttpStatus.OK.value(), "User Successfully saved and JWT successfully generated!", jwtService.generateToken(userRoles,userDetails));

//        response.setStatusCode(HttpStatus.OK.value());
//        response.setMessage("User successfully registered and JWT Successfully generated!");
//        response.setData(jwtService.generateToken(userDetails));
//        return response;
//    }

//    public Response createAndSendResponse(int statusCode, String message, Object data) {
//        response.setStatusCode(statusCode);
//        response.setMessage(message);
//        response.setData(data);
//        return response;
//    }
//}
