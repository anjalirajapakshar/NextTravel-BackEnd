package com.anjali.uas.endpoints;

import com.anjali.uas.dto.PackageDetailDTO;
import com.anjali.uas.interfaces.PackageDetailControllerInterface;
import com.anjali.uas.model.PackageDetail;
import com.anjali.uas.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/packagedetail")
@CrossOrigin
public class PackageDetailController {
    @Autowired
    private PackageDetailControllerInterface packageDetailControllerInterface;

    @PostMapping(path = "/spd", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response savePackageDetail(@RequestBody PackageDetailDTO packageDetailDTO) {
        return packageDetailControllerInterface.savePackageDetail(packageDetailDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackageDetailDTO packageDetailDTO) {
        return packageDetailControllerInterface.update(packageDetailDTO);
    }

    @GetMapping(path = "/search", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("packageDetailId") String packageDetailId) {
        return packageDetailControllerInterface.search(packageDetailId);
    }

    @DeleteMapping(path = "/delete", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("packageDetailId") String packageDetailId) {
        return packageDetailControllerInterface.delete(packageDetailId);
    }

    @GetMapping(path = "/getPayment", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<PackageDetail> getPackageDetail(@RequestParam("packageDetailId") String packageDetailId) {
        return packageDetailControllerInterface.getPackageDetail(packageDetailId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return packageDetailControllerInterface.getAll();
    }

    @GetMapping(path = "/getPackageDetailByUserName", params = "PackageDetailName")
    public PackageDetailDTO getPackageDetailByUserName(@RequestParam("PackageDetailName") String packageDetailName){
        return packageDetailControllerInterface.getPackageDetailByUserName(packageDetailName);
    }
}
