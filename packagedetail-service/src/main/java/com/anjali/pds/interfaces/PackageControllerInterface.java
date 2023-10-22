package com.anjali.pds.interfaces;

import com.anjali.pds.dto.PackagesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PACKAGE-SERVICE")
public interface PackageControllerInterface {
    @GetMapping(path = "/getPackage", params = "packagesId")
    public PackagesDTO getPackage(@RequestParam("packagesId") String packagesId);
}
