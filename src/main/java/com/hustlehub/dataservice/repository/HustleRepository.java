package com.hustlehub.dataservice.repository;

import com.hustlehub.dataservice.entity.HustleEntity;
import com.hustlehub.dataservice.entity.VoyagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface HustleRepository extends JpaRepository<HustleEntity, String> {

    Optional<HustleEntity> findById(String id);

    @Query(value = "SELECT * FROM HUSTLES WHERE status = :status", nativeQuery = true)
    List<HustleEntity> findByStatus(@Param("status") String status);
}
