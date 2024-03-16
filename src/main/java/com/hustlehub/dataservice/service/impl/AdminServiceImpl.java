package com.hustlehub.dataservice.service.impl;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.entity.HustleEntity;
import com.hustlehub.dataservice.entity.SailorEntity;
import com.hustlehub.dataservice.repository.HustleRepository;
import com.hustlehub.dataservice.repository.SailorRepository;
import com.hustlehub.dataservice.service.AdminService;
import com.hustlehub.dataservice.service.SailorService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private SailorRepository sailorRepository;

    @Autowired
    private HustleRepository hustleRepository;


    @Transactional
    @Override
    public Sailor approveSailor(String id) {
        SailorEntity sailorEntity = sailorRepository.findById(id).get();
        //Check and review

        sailorEntity.setStatus(Status.APPROVED);
        sailorEntity.setApprovedBy("ADMIN");
        sailorEntity = sailorRepository.save(sailorEntity);
        return Sailor.builder().userName(sailorEntity.getUserId())
                .id(sailorEntity.getId()).tag(sailorEntity.getTag())
                .status(sailorEntity.getStatus()).build();
    }

    @Transactional
    @Override
    public Hustle approveHustle(String sailorId, String hustleId) {
        SailorEntity sailorEntity = sailorRepository.findById(sailorId).get();
        HustleEntity hustleEntity = hustleRepository.findById(hustleId).get();

        //verify sailor and hustle details and approve

        hustleEntity.setStatus(Status.APPROVED);
        hustleEntity.setApprovedBy("ADMIN");
        hustleRepository.save(hustleEntity);
        return Hustle.builder().id(hustleId).approvedBy("ADMIN").status(Status.APPROVED).build();
    }

    @Override
    public void startApprovedHustles(){
        List<HustleEntity> approvedHustles = hustleRepository.findByStatus(Status.APPROVED.name());
        List<HustleEntity> activeHustles = new ArrayList<>();
        for(HustleEntity hustleEntity : approvedHustles){
            // logic to activate hustles. currently checking APPROVED status
            hustleEntity.setStatus(Status.ACTIVE);
            hustleEntity.setStartDate(LocalDateTime.now());
            // set end date based on tenure
           // hustleEntity.setEndDate();
            activeHustles.add(hustleEntity);
        }
        hustleRepository.saveAll(activeHustles);
    }
}
