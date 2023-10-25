package com.anjali.pds.interfaces;

import com.anjali.pds.dto.PackagesDTO;
import com.anjali.pds.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PACKAGE-SERVICE")
public interface PackageControllerInterface {
    @GetMapping(path = "/getPackage", params = "packagesId")
    public PackagesDTO getPackage(@RequestParam("packagesId") String packagesId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();
    @GetMapping(path = "/getPackageByUserName", params = "PackageName")
    public Response getPackageByUserName(@RequestParam("PackageName") String packageName);
}
