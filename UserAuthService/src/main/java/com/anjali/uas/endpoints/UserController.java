package com.anjali.uas.endpoints;

import com.anjali.uas.dto.UserDetailsDTO;
import com.anjali.uas.response.Response;
import com.anjali.uas.service.UserDetailsServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserDetailsServicee userDetailsServicee;
/*
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody UserDetailsDTO userDetailsDTO) {
        return userDetailsServicee.save(userDetailsDTO);
    }*/

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody UserDetailsDTO userDetailsDTO) {
        return userDetailsServicee.update(userDetailsDTO);
    }

    @GetMapping(path = "/search", params = "userId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("userId") String guideId) {
        return userDetailsServicee.search(guideId);
    }

    @DeleteMapping(path = "/delete", params = "userId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("userId") String guideId) {
        return userDetailsServicee.delete(guideId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return userDetailsServicee.getAll();
    }

    @PutMapping( value = "/getPaymentId",params = {"paymentID","userID"})
    public Response getPaymentIds(@RequestParam("paymentID") String PaymentID, @RequestParam("userID") String UserID){
        return userDetailsServicee.savePaymentIds(PaymentID,UserID);
    }

    @PutMapping( value = "/getPackageDetailId",params = {"PackageDetailId","UserId"})
    Response getPackageDetailIds(@RequestParam("PackageDetailId") String packageDetailId,@RequestParam("UserId")  String userId){
        return userDetailsServicee.savePackageDetailIds(packageDetailId,userId);
    }

    @GetMapping(path = "/getUserDetailsByUserName", params = "UserName")
    public Response getUserDetailsByUserName(@RequestParam("UserName") String UserName){
        return userDetailsServicee.getUserDetailByUserName(UserName);
    }
    @GetMapping(path = "/validate",params = {"username","password"},produces = MediaType.APPLICATION_JSON_VALUE)
    public Response validateUser(@RequestParam("username") String username,@RequestParam("password")String password){
        System.out.println("Request Received!");
       return userDetailsServicee.validateAndGetUser(username,password);

    }
}

//{
//        "userId": "USER001",
//        "userName": "anjali",
//        "pw": "anjali123",
//        "role": "USER",
//        "userNIC": "200173203003",
//        "userAddress": "123 Main Street, City",
//        "userDOB": "2001-05-15",
//        "userPhone": "0778654344",
//        "userEmail": "anjali@example.com",
//        "gender": "Female",
//        "userNICimageLocation": "/path/to/nic/anjaliImage.jpg",
//        "userImageLocation": "/path/to/user/anjaliImage.jpg"
//}