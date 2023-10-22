package com.anjali.pds.repo;

import com.anjali.pds.entity.PackageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PackageDetailRepo extends JpaRepository<PackageDetail, String> {

    @Query("SELECT p FROM PackageDetail p WHERE p.packageCategory = :username")
    PackageDetail findPackageDetailByUsername(@Param("username") String username);
}
