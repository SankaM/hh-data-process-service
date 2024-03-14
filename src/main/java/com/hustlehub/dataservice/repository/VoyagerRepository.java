package com.hustlehub.dataservice.repository;

import com.hustlehub.dataservice.entity.SailorEntity;
import com.hustlehub.dataservice.entity.VoyagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VoyagerRepository extends JpaRepository<VoyagerEntity, String> {

    VoyagerEntity findById(UUID id);
}
