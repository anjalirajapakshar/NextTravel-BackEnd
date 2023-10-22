package com.anjali.gs.repo;

import com.anjali.gs.dto.GuideDTO;
import com.anjali.gs.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideRepo extends JpaRepository<Guide, String> {

    @Query("SELECT g FROM Guide g WHERE g.guideName = :username")
    Guide findGuideByUsername(@Param("username") String username);


    @Query("SELECT g.guideId from Guide g order by g.guideId DESC")
    List<String> getLastId();
}
