package com.hustlehub.dataservice.repository;

import com.hustlehub.dataservice.entity.VoyagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoyagerRepository extends JpaRepository<VoyagerEntity, String> {

    Optional<VoyagerEntity> findById(String id);
}
