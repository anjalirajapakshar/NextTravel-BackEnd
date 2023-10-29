package com.anjali.pds.repo;

import com.anjali.pds.entity.PackageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PackageDetailRepo extends JpaRepository<PackageDetail, String> {

    @Query("SELECT p FROM PackageDetail p WHERE p.packageCategory = :username")
    PackageDetail findPackageDetailByUsername(@Param("username") String username);

    @Query("SELECT p.packageDetailId from PackageDetail p order by p.packageDetailId DESC")
    List<String> getLastId();

    @Query("SELECT p FROM PackageDetail p WHERE p.userId = :username")
    PackageDetail findPackageDetailByUserId(@Param("username") String username);
}
