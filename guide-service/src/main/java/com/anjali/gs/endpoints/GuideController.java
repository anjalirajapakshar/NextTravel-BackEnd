package com.anjali.gs.endpoints;

import com.anjali.gs.dto.GuideDTO;
import com.anjali.gs.repo.GuideRepo;
import com.anjali.gs.response.Response;
import com.anjali.gs.service.custom.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("")
@CrossOrigin
public class GuideController {

    @GetMapping(path = "/demo")
    public String getHello(){
        return "FUUUUUUUUUUUCK";
    }

    @Autowired
    private GuideService guideService;

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveGuide(@Valid  @RequestBody GuideDTO guideDTO){
        return guideService.save(guideDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@Valid @RequestBody GuideDTO guideDTO) {
        return guideService.update(guideDTO);
    }

    @GetMapping(path = "/search", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search( @RequestParam("guideId") String guideId) {
        return guideService.search(guideId);
    }

    @GetMapping(path = "/getGuide", params = "guideId")
    public GuideDTO getGuide( @RequestParam("guideId") String guideId) {
        return guideService.getGuide(guideId);
    }

    @GetMapping(path = "/getGuideByUserName", params = "GuideUserName")
    public Response getGuideByUserName(@RequestParam("GuideUserName") String guideUserName){
        return guideService.getGuideByUserName(guideUserName);
    }

    @DeleteMapping(path = "/delete", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("guideId") String guideId) {
        return guideService.delete(guideId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return guideService.getAll();
    }
}

//{
//        "guideId": "G003",
//        "guideName": "Nimal",
//        "guideAddress": "kaluthara",
//        "guideAge": 40,
//        "gender": "Male",
//        "guideContact": "0765657098",
//        "guideImageLocation": "/images/Nimal.jpg",
//        "guideNICImageLocation": "/images/NimalNic.jpg",
//        "guideIDImageLocation": "/images/Nimalid.jpg",
//        "guideExperience": "Experienced tour guide with 5 years of service.",
//        "manDayValue": "35000"
//}