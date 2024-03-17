package com.hustlehub.dataservice.repository;

import com.hustlehub.dataservice.entity.AmuletEntity;
import com.hustlehub.dataservice.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmuletRepository extends JpaRepository<AmuletEntity, String> {

    List<AmuletEntity> findByVoyagerId(String voyagerId);
}
