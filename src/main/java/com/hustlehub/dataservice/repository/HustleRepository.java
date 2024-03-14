package com.hustlehub.dataservice.repository;

import com.hustlehub.dataservice.entity.HustleEntity;
import com.hustlehub.dataservice.entity.VoyagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HustleRepository extends JpaRepository<HustleEntity, String> {

    HustleEntity findById(UUID id);
}
