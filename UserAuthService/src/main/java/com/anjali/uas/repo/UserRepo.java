package com.anjali.uas.repo;


import com.anjali.uas.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserDetails,String> {
    Optional<UserDetails> findByUserName (String username);

    @Query("SELECT g FROM UserDetails g WHERE g.userName = :username")
    UserDetails findUserDetailByUsername(@Param("username") String username);

    @Query("SELECT u.userId from UserDetails u order by u.userId DESC")
    List<String> getLastId();
}
