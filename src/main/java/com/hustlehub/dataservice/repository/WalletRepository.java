package com.hustlehub.dataservice.repository;

import com.hustlehub.dataservice.entity.DepositEntity;
import com.hustlehub.dataservice.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, String> {
}
