package com.hustlehub.dataservice.service.impl;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.entity.HustleEntity;
import com.hustlehub.dataservice.entity.SailorEntity;
import com.hustlehub.dataservice.repository.SailorRepository;
import com.hustlehub.dataservice.service.HustleService;
import com.hustlehub.dataservice.service.SailorService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;


@Service
public class SailorServiceImpl implements SailorService {

    private static final Logger log = LoggerFactory.getLogger(SailorServiceImpl.class);

    @Autowired
    private SailorRepository sailorRepository;

    @Autowired
    private HustleService hustleService;


    @Transactional
    @Override
    public Sailor createSailor(CreateSailorRequest createSailorRequest) {
        SailorEntity sailorEntity = SailorEntity.builder()
                .id(UUID.randomUUID().toString())
                .tag(createSailorRequest.getTag())
                .userId(createSailorRequest.getUserName()).build();
        sailorEntity = sailorRepository.save(sailorEntity);
        log.info("Created sailor in the system");
        return Sailor.builder().userName(sailorEntity.getUserId())
                .id(sailorEntity.getId()).tag(sailorEntity.getTag())
                .status(Status.INITIATED).build();
    }

    @Override
    public Sailor getSailor(String id){
        SailorEntity sailorEntity =  sailorRepository.findById(id).get();
        return Sailor.builder()
                .id(sailorEntity.getId())
                .tag(sailorEntity.getTag())
                .userName(sailorEntity.getUserId())
                .status(sailorEntity.getStatus()).build();
    }

    @Override
    public Hustle createHustle(String sailorId, CreateHustleRequest createHustleRequest) {
        Sailor sailor = null;
        try {
             sailor = getSailor(sailorId);
        }catch(NoSuchElementException ex ) {
            throw new RuntimeException("SailorNotFound");
        }
        if(null != sailor) {
            return  hustleService.createHustle(sailorId, createHustleRequest);
        }else{
            throw new RuntimeException("SailorNotFound");
        }
    }
}
