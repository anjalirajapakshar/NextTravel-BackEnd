package com.anjali.gs.service.custom.Impl;

import com.anjali.gs.dto.GuideDTO;
import com.anjali.gs.entity.Guide;
import com.anjali.gs.repo.GuideRepo;
import com.anjali.gs.response.Response;
import com.anjali.gs.service.custom.GuideService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GuideServiceImpl implements GuideService {
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GuideRepo guideRepo;


    @Override
    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(GuideDTO guideDTO) {
//        System.out.println(generateNextUserId());
//        guideDTO.setGuideId(generateNextUserId());

        if (search(guideDTO.getGuideId()).getData() == null) {
            guideRepo.save(modelMapper.map(guideDTO, Guide.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Guide Successfully saved!", null);
        }
        throw new RuntimeException("Guide already exists!");
    }

    @Override
    public Response update(GuideDTO guideDTO) {
        if (search(guideDTO.getGuideId()).getData() != null) {
            guideRepo.save(modelMapper.map(guideDTO, Guide.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Guide Successfully updated!", null);
        }
        throw new RuntimeException("Guide does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            guideRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "Guide Successfully deleted!", null);
        }
        throw new RuntimeException("Guide does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<Guide> guide = guideRepo.findById(s);
        if (guide.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Guide Successfully retrieved!", modelMapper.map(guide.get(), GuideDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Guide does not exists!", null);
    }

    @Override
    public GuideDTO getGuide(String s) {
        Optional<Guide> guide = guideRepo.findById(s);

        if (guide.isPresent()) {
            System.out.println(guide.get());
            return modelMapper.map(guide.get(), GuideDTO.class);
        }
        throw new RuntimeException("guide cannot found!!!");
    }

    @Override
    public Response getAll() {
        List<Guide> guides = guideRepo.findAll();
        if (!guides.isEmpty()) {
            ArrayList<GuideDTO> guides_dtos = new ArrayList<>();
            guides.forEach((guidess) -> {
                guides_dtos.add(modelMapper.map(guidess, GuideDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Guides Successfully retrieved!", guides_dtos);
        }
        throw new RuntimeException("No Guides found in the database!");
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    @Override
    public Response getGuideByUserName(String guideUserName) {
        Optional<Guide> guide = guideRepo.findByGuideName(guideUserName);
        System.out.println(guide.get());

        if(guide.isPresent()){
            System.out.println(guide.get());
            GuideDTO guideDTO = modelMapper.map(guide.get(), GuideDTO.class);
            return createAndSendResponse(HttpStatus.OK.value(), "Guides Successfully retrieved!", guideDTO);
        }

        throw new RuntimeException("Guide cannot find!!");
    }

    public String generateNextUserId() {
        List<String> lastIds = guideRepo.findGuideIdsByOrderByGuideIdDesc();
        System.out.println(lastIds);

        if (lastIds != null && !lastIds.isEmpty()) {
            String lastId = lastIds.get(0);
            System.out.println(lastId);

            // Check if the last ID matches the expected format "U00X" or "U0X" or "UXX"
            if (lastId.matches("G\\d{1,3}")) {
                return generateNextUserId(lastId);
            }
        }

        return "G001"; // Fallback if the format is not as expected
    }

    private static String generateNextUserId(String currentUserId) {
        if (currentUserId != null && currentUserId.matches("G\\d{1,3}")) {
            int id = Integer.parseInt(currentUserId.replace("G", ""));
            id += 1;
            return "G" + String.format("%03d", id);
        }
        return "G001"; // Fallback if the format is not as expected
    }
}
