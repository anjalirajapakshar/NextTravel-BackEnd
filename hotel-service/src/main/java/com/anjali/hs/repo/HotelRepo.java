package com.anjali.hs.repo;

import com.anjali.hs.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepo  extends JpaRepository<Hotel, String> {

    @Query("SELECT h FROM Hotel h WHERE h.hotelName = :username")
    Hotel findHotelByUsername(@Param("username") String username);

    @Query("SELECT h.hotelID from Hotel h order by h.hotelID DESC")
    List<String> getLastId();
}
