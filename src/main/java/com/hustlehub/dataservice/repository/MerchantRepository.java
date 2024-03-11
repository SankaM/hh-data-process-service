package com.hustlehub.dataservice.repository;

import com.hustlehub.dataservice.entity.DepositEntity;
import com.hustlehub.dataservice.entity.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, String> {

    MerchantEntity findById(UUID id);
}
