package com.hustlehub.dataservice.service.impl;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.entity.SailorEntity;
import com.hustlehub.dataservice.entity.VoyagerEntity;
import com.hustlehub.dataservice.repository.SailorRepository;
import com.hustlehub.dataservice.repository.VoyagerRepository;
import com.hustlehub.dataservice.service.VoyagerService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class VoyagerServiceImpl implements VoyagerService {

    private static final Logger log = LoggerFactory.getLogger(VoyagerServiceImpl.class);

    @Autowired
    private VoyagerRepository voyagerRepository;


    @Transactional
    @Override
    public Voyager createVoyager(CreateVoyagerRequest createVoyagerRequest) {
        VoyagerEntity voyagerEntity = VoyagerEntity.builder()
                .id(UUID.randomUUID().toString()).status(Status.INITIATED)
                .name(createVoyagerRequest.getName())
                .userName(createVoyagerRequest.getUserName()).build();
        voyagerEntity = voyagerRepository.save(voyagerEntity);
        log.info("Created voyager in the system");
        return Voyager.builder().userName(voyagerEntity.getUserName()).name(voyagerEntity.getName())
                .status(voyagerEntity.getStatus())
                .id(voyagerEntity.getId()).build();
    }

    @Override
    public Voyager getVoyager(String id){
        VoyagerEntity voyagerEntity =  voyagerRepository.findById(id).get();
        return Voyager.builder().userName(voyagerEntity.getUserName()).name(voyagerEntity.getName())
                .status(voyagerEntity.getStatus())
                .id(voyagerEntity.getId()).build();
    }
}
