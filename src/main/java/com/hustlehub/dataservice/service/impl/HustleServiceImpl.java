package com.hustlehub.dataservice.service.impl;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.entity.HustleEntity;
import com.hustlehub.dataservice.entity.VoyagerEntity;
import com.hustlehub.dataservice.repository.HustleRepository;
import com.hustlehub.dataservice.repository.VoyagerRepository;
import com.hustlehub.dataservice.service.HustleService;
import com.hustlehub.dataservice.service.VoyagerService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class HustleServiceImpl implements HustleService {

    private static final Logger log = LoggerFactory.getLogger(HustleServiceImpl.class);

    @Autowired
    private HustleRepository hustleRepository;


    @Transactional
    @Override
    public Hustle createHustle(CreateHustleRequest createHustleRequest) {
        HustleEntity hustleEntity = HustleEntity.builder()
                .id(UUID.randomUUID())
                .build();
        hustleEntity = hustleRepository.save(hustleEntity);
        log.info("Created hustle in the system");
        return Hustle.builder()
                .id(hustleEntity.getId()).build();
    }

    @Override
    public Hustle getHustle(String id){
        HustleEntity hustleEntity =  hustleRepository.findById(id).get();
        return Hustle.builder()
                .id(hustleEntity.getId()).build();
    }
}
