package com.hustlehub.dataservice.repository;

import com.hustlehub.dataservice.entity.SailorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SailorRepository extends JpaRepository<SailorEntity, String> {

    Optional<SailorEntity> findById(String id);
}
