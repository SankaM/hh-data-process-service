package com.hustlehub.dataservice.repository;

import com.hustlehub.dataservice.entity.DepositEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<DepositEntity, String> {
}
