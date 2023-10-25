package com.anjali.pds.interfaces;

import com.anjali.pds.dto.GuideDTO;
import com.anjali.pds.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "GUIDE-SERVICE")
public interface GuideControllerInterface {
    @GetMapping(path = "/search", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public GuideDTO getGuideDTO(@RequestParam("guideId") String guideId);

    @GetMapping(path = "/getGuideByUserName", params = "GuideUserName")
    public Response getGuideByUserName(@RequestParam("GuideUserName") String guideUserName);
}
