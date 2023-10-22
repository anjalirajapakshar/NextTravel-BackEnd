package com.anjali.vs.repo;

import com.anjali.vs.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepo  extends JpaRepository<Vehicle, String> {

    @Query("SELECT g FROM Vehicle g WHERE g.vehicleBrand = :username")
    Vehicle findVehicleByUsername(@Param("username") String username);

    @Query("SELECT p.vehicleID from Vehicle p order by p.vehicleID DESC")
    List<String> getLastId();
}
