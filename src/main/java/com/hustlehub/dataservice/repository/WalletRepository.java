package com.hustlehub.dataservice.repository;

import com.hustlehub.dataservice.dto.Wallet;
import com.hustlehub.dataservice.entity.DepositEntity;
import com.hustlehub.dataservice.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, String> {

    List<WalletEntity> findWalletByVoyagerId(String voyagerId);
}
