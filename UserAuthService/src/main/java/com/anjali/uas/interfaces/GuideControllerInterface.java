package com.anjali.uas.interfaces;

import com.anjali.uas.dto.GuideDTO;
import com.anjali.uas.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "GUIDE-SERVICE")
public interface GuideControllerInterface {
    @GetMapping(path = "/demo")
    String getHello();

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveGuide(@RequestBody GuideDTO guideDTO);

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody GuideDTO guideDTO);

    @GetMapping(path = "/search", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("guideId") String guideId);

    @DeleteMapping(path = "/delete", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("guideId") String guideId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();

    @GetMapping(path = "/getGuideByUserName", params = "GuideUserName")
    public Response getGuideByUserName(@RequestParam("GuideUserName") String guideUserName);

}