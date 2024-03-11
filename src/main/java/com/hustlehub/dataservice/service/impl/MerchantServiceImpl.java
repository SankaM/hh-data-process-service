package com.hustlehub.dataservice.service.impl;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.entity.DepositEntity;
import com.hustlehub.dataservice.entity.MerchantEntity;
import com.hustlehub.dataservice.mapper.DepositEntityMapper;
import com.hustlehub.dataservice.repository.DepositRepository;
import com.hustlehub.dataservice.repository.MerchantRepository;
import com.hustlehub.dataservice.service.DepositService;
import com.hustlehub.dataservice.service.MerchantService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class MerchantServiceImpl implements MerchantService {

    private static final Logger log = LoggerFactory.getLogger(MerchantServiceImpl.class);

    @Autowired
    private MerchantRepository merchantRepository;


    @Transactional
    @Override
    public CreateMerchantResponse createMerchant(CreateMerchantRequest createMerchantRequest) {
        MerchantEntity merchantEntity = MerchantEntity.builder()
                .id(UUID.randomUUID())
                .userId(createMerchantRequest.getUserName()).build();
        merchantEntity = merchantRepository.save(merchantEntity);
        log.info("Created merchant in the system");
        return CreateMerchantResponse.builder().userName(merchantEntity.getUserId())
                .id(merchantEntity.getId()).build();
    }

    @Override
    public Merchant getMerchant(UUID id){
        MerchantEntity merchantEntity =  merchantRepository.findById(id);
        return Merchant.builder()
                .id(merchantEntity.getId()).userName(merchantEntity.getUserId()).build();
    }

    private void validateDepositRequest(DepositRequest depositRequest) {
        if (depositRequest == null || depositRequest.getAmount() == null
                || depositRequest.getCurrency() == null) {
            log.error("Invalid request");
            throw new RuntimeException("Invalid Request");
        }
    }

}
