package com.anjali.uas.service;


import com.anjali.uas.config.JWTService;
import com.anjali.uas.dto.UserDetailsDTO;
import com.anjali.uas.interfaces.PackageDetailControllerInterface;
import com.anjali.uas.interfaces.PaymentControllerInterface;
import com.anjali.uas.model.UserDetails;
import com.anjali.uas.repo.UserRepo;
import com.anjali.uas.response.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService,UserDetailsServicee{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PackageDetailControllerInterface packageDetailControllerInterface;

    @Autowired
    private PaymentControllerInterface paymentControllerInterface;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.anjali.uas.model.UserDetails> user = userRepo.findByUserName(username);
        return user.isPresent() ? user.get() : user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }


    @Override
    public Response save(UserDetailsDTO userDetailsDTO) {
        if (search(userDetailsDTO.getUserId()).getData() == null) {
            System.out.println(generateNextUserId());
            userDetailsDTO.setUserId(generateNextUserId());

            UserDetails userDetails = modelMapper.map(userDetailsDTO, UserDetails.class);

            String password = passwordEncoder.encode(userDetails.getPassword());
            userDetails.setPw(password);
            userRepo.save(userDetails);

            HashMap<String,Object> userRoles= new HashMap<>();
            userRoles.put("userRole",userDetails.getRole());
            return createAndSendResponse(HttpStatus.OK.value(), "User Successfully saved and JWT successfully generated!", jwtService.generateToken(userRoles,userDetails));

        }
        throw new RuntimeException("User already exists!");
    }

    @Override
    public Response update(UserDetailsDTO userDetailsDTO) {
        if (search(userDetailsDTO.getUserId()).getData() != null) {

            String password = passwordEncoder.encode(userDetailsDTO.getPw());
            userDetailsDTO.setPw(password);

            userRepo.save(modelMapper.map(userDetailsDTO, UserDetails.class));
            return createAndSendResponse(HttpStatus.OK.value(), "User Successfully updated!", null);
        }
        throw new RuntimeException("User does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {

            Optional<UserDetails> userDetails = userRepo.findById(s);
            System.out.println(userDetails.get());
            System.out.println(userDetails.get().getUserId());

            paymentControllerInterface.getUserId(userDetails.get().getUserId());
            packageDetailControllerInterface.getUserId(userDetails.get().getUserId());

            userRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "User Successfully deleted!", null);
        }
        throw new RuntimeException("User does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<UserDetails> userDetails = userRepo.findById(s);
        if (userDetails.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "User Successfully retrieved!", modelMapper.map(userDetails.get(), UserDetails.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "User does not exists!", null);
    }

    @Override
    public UserDetailsDTO getUserDetails(String s) {
        Optional<UserDetails> userDetails = userRepo.findById(s);

        if (userDetails.isPresent()) {
            System.out.println(userDetails.get());
            return modelMapper.map(userDetails.get(), UserDetailsDTO.class);
        }
        throw new RuntimeException("userdetail cannot found!!!");
    }

    @Override
    public Response getAll() {
        List<UserDetails> users = userRepo.findAll();
        if (!users.isEmpty()) {
            ArrayList<UserDetailsDTO> userDetails_dtos = new ArrayList<>();
            users.forEach((userDetails) -> {
                userDetails_dtos.add(modelMapper.map(userDetails, UserDetailsDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Users Successfully retrieved!", userDetails_dtos);
        }
        throw new RuntimeException("No Users found in the database!");
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    @Override
    public Response savePaymentIds(String paymentId, String userID) {
        System.out.println("ygutfytfyrdtry");
        Optional<UserDetails> userDetails = userRepo.findById(userID);
        if(userDetails.isPresent()){

            System.out.println("yguuuuuuuuuuuuuuuuuuuuuuuuy");
//            userDetails.get().getPaymentsList().add(paymentId);
//
//
////            System.out.println(userDetails.get());
//            System.out.println(userDetails.get().getPaymentsList());
            return createAndSendResponse(HttpStatus.FOUND.value(), "Success!(", null);
        }
        throw new RuntimeException("Payment is not found!");
    }

    @Override
    public Response savePackageDetailIds(String packageDetailId, String userId) {
        System.out.println("ygutfytfyrdtry");
        Optional<UserDetails> userDetails = userRepo.findById(userId);
        if(userDetails.isPresent()){

            System.out.println("yguuuuuuuuuuuuuuuuuuuuuuuuy");
//            userDetails.get().getPackageDetailsList().add(packageDetailId);
//
//
////            System.out.println(userDetails.get());
//            System.out.println(userDetails.get().getPackageDetailsList());
            return createAndSendResponse(HttpStatus.FOUND.value(), "Success!(", null);
        }
        throw new RuntimeException("PackageDetail is not found!");
    }

    @Override
    public Response getUserDetailByUserName(String UserName) {
        UserDetails userDetails = userRepo.findUserDetailByUsername(UserName);
        System.out.println(userDetails);

        UserDetailsDTO userDetailsDTO = modelMapper.map(userDetails, UserDetailsDTO.class);

        if (userDetailsDTO != null){
            return createAndSendResponse(HttpStatus.OK.value(), "Success!(", userDetailsDTO);
        }
        throw new RuntimeException("userDetail cannot find!!");
    }

    @Override
    public Response validateAndGetUser(String username, String password) {
        Optional<UserDetails> user = userRepo.findByUserName(username);
        if(user.isPresent()){
            UserDetailsDTO userDetailsDTO = modelMapper.map(user.get(), UserDetailsDTO.class);
            System.out.println("Stored password : "+userDetailsDTO.getPw());
            System.out.println("Entered password : "+password);

          if(passwordValidator(password, userDetailsDTO.getPw())){
              userDetailsDTO.setValidated(true);
              System.out.println(userDetailsDTO);
              return createAndSendResponse(HttpStatus.OK.value(), "User successfully validated!",userDetailsDTO);

          }


        }
        return createAndSendResponse(HttpStatus.FORBIDDEN.value(), "User is not validated!",null);

    }

    @Override
    public boolean passwordValidator(String enterdPassword, String hashedPassword) {
        return passwordEncoder.matches(enterdPassword,hashedPassword);
    }
    public String generateNextUserId() {
        List<String> lastIds = userRepo.getLastId();
        System.out.println(lastIds);

        if (lastIds != null && !lastIds.isEmpty()) {
            String lastId = lastIds.get(0);
            System.out.println(lastId);

            // Check if the last ID matches the expected format "U00X" or "U0X" or "UXX"
            if (lastId.matches("U\\d{1,3}")) {
                return generateNextUserId(lastId);
            }
        }

        return "U001"; // Fallback if the format is not as expected
    }

    private static String generateNextUserId(String currentUserId) {
        if (currentUserId != null && currentUserId.matches("U\\d{1,3}")) {
            int id = Integer.parseInt(currentUserId.replace("U", ""));
            id += 1;
            return "U" + String.format("%03d", id);
        }
        return "U001"; // Fallback if the format is not as expected
    }


}
