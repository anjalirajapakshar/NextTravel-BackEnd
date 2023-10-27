package com.anjali.gs.repo;

import com.anjali.gs.dto.GuideDTO;
import com.anjali.gs.entity.Guide;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuideRepo extends MongoRepository<Guide, String> {

    List<String> findGuideIdsByOrderByGuideIdDesc();

    Optional<Guide> findByGuideName(String guideName);
}
