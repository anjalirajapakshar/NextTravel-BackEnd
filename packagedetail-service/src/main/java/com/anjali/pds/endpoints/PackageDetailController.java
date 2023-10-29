package com.anjali.pds.endpoints;

import com.anjali.pds.dto.PackageDetailDTO;
import com.anjali.pds.entity.PackageDetail;
import com.anjali.pds.response.Response;
import com.anjali.pds.service.custom.PackageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
@CrossOrigin
public class PackageDetailController {
    @Autowired
    private PackageDetailService packageDetailService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response savePackageDetail(@Valid @RequestBody PackageDetailDTO packageDetailDTO) {
        return packageDetailService.save(packageDetailDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@Valid @RequestBody PackageDetailDTO packageDetailDTO) {
        return packageDetailService.update(packageDetailDTO);
    }

    @GetMapping(path = "/search", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("packageDetailId") String packageDetailId) {
        return packageDetailService.search(packageDetailId);
    }

    @DeleteMapping(path = "/delete", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("packageDetailId") String packageDetailId) {
        return packageDetailService.delete(packageDetailId);
    }

    @GetMapping(path = "/getPackageDetail")
    public PackageDetailDTO getPackageDetail(@RequestParam("packageDetailId") String packageDetailId) {
        return packageDetailService.getPackageDetail(packageDetailId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return packageDetailService.getAll();
    }

    @PutMapping( value = "/getUserId")
    public Response getUserId(@RequestBody String UserId){
        return packageDetailService.deletePackageDetails(UserId);
    }

    @GetMapping(path = "/getPackageDetailByUserName", params = "PackageDetailName")
    public Response getPackageDetailByUserName(@RequestParam("PackageDetailName") String packageDetailName){
        return packageDetailService.getPackageDetailByUserName(packageDetailName);
    }
}
