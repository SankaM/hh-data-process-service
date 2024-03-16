package com.hustlehub.dataservice.repository;

import com.hustlehub.dataservice.entity.AmuletEntity;
import com.hustlehub.dataservice.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmuletRepository extends JpaRepository<AmuletEntity, String> {
}
