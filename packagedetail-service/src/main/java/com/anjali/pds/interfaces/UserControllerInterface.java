package com.anjali.pds.interfaces;

import com.anjali.pds.dto.UserDetailsDTO;
import com.anjali.pds.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

//,url = "localhost:8081/api/v1/user"

@FeignClient(name = "USER-AUTH-SERVICE")
public interface UserControllerInterface {
    @GetMapping(path = "/getUserDetail")
    public UserDetailsDTO getUserDetail(@RequestParam("userDetailId") String userDetailId);

    @PutMapping( value = "/getPackageDetailId",params = {"PackageDetailId","UserId"})
    void getPackageDetailIds(@RequestParam("PackageDetailId") String packageDetailId,@RequestParam("UserId")  String userId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();

    @GetMapping(path = "/getUserDetailsByUserName", params = "UserName")
    public Response getUserDetailsByUserName(@RequestParam("UserName") String UserName);

}
