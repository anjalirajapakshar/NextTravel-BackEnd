package com.anjali.ps.repo;

import com.anjali.ps.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PackageRepo extends JpaRepository<Packages, String> {

    @Query("SELECT p FROM Packages p WHERE p.packageCategory = :username")
    Packages findPackageByUsername(@Param("username") String username);

    @Query("SELECT p.packageId from Packages p order by p.packageId DESC")
    List<String> getLastId();
}
