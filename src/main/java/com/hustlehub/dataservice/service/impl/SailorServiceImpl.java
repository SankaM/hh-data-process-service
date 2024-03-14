package com.hustlehub.dataservice.service.impl;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.entity.MerchantEntity;
import com.hustlehub.dataservice.repository.MerchantRepository;
import com.hustlehub.dataservice.service.SailorService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class SailorServiceImpl implements SailorService {

    private static final Logger log = LoggerFactory.getLogger(SailorServiceImpl.class);

    @Autowired
    private MerchantRepository merchantRepository;


    @Transactional
    @Override
    public CreateSailorResponse createMerchant(CreateMerchantRequest createMerchantRequest) {
        MerchantEntity merchantEntity = MerchantEntity.builder()
                .id(UUID.randomUUID())
                .userId(createMerchantRequest.getUserName()).build();
        merchantEntity = merchantRepository.save(merchantEntity);
        log.info("Created merchant in the system");
        return CreateSailorResponse.builder().userName(merchantEntity.getUserId())
                .id(merchantEntity.getId()).build();
    }

    @Override
    public Sailor getMerchant(UUID id){
        MerchantEntity merchantEntity =  merchantRepository.findById(id);
        return Sailor.builder()
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
