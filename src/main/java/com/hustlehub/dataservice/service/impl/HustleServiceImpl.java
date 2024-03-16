package com.hustlehub.dataservice.service.impl;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.entity.HustleEntity;
import com.hustlehub.dataservice.repository.HustleRepository;
import com.hustlehub.dataservice.service.HustleService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class HustleServiceImpl implements HustleService {

    private static final Logger log = LoggerFactory.getLogger(HustleServiceImpl.class);

    @Autowired
    private HustleRepository hustleRepository;


    @Override
    public Hustle createHustle(String sailorId, CreateHustleRequest createHustleRequest) {
        HustleEntity hustleEntity = HustleEntity.builder()
                .id(UUID.randomUUID().toString())
                .cardValue(createHustleRequest.getCardValue())
                .status(Status.INITIATED)
                .name(createHustleRequest.getName())
                .totalCardCount(createHustleRequest.getCardCount())
                .soldCardCount(0L)
                .totalCapitalRaised(BigDecimal.ZERO)
                .valuation(createHustleRequest.getValuation())
                .currency(createHustleRequest.getCurrency())
                .returnPeriod(createHustleRequest.getReturnPeriod())
                .returnType(createHustleRequest.getReturnType())
                .description(createHustleRequest.getDescription())
                .returnValue(createHustleRequest.getReturnValue())
                .tenure(createHustleRequest.getTenure())
                .tenureUnit(createHustleRequest.getTenureUnit())
                .sailorId(sailorId)
                .totalReturnPerCard(createHustleRequest.getTotalReturnPerCard())
                .build();
        hustleEntity = hustleRepository.save(hustleEntity);
        log.info("Created hustle in the system");
        return getHustle(hustleEntity);
    }

    @Override
    public Hustle getHustle(String id){
        HustleEntity hustleEntity =  hustleRepository.findById(id).get();
        return getHustle(hustleEntity);
    }

    @Transactional
    @Override
    public HustleEntity getHustleEntity(String id){
        //try catch
       return hustleRepository.findById(id).get();
    }

    @Transactional
    @Override
    public HustleEntity saveHustleEntity(HustleEntity hustleEntity){
        //try catch
        return hustleRepository.save(hustleEntity);
    }

    @Override
    public List<Hustle> getActiveHustles(){
        List<HustleEntity> activeHustleEntities = hustleRepository.findByStatus(Status.ACTIVE.name());
        List<Hustle> activeHustles = new ArrayList<>();
        for(HustleEntity hustleEntity : activeHustleEntities){
            activeHustles.add(getHustle(hustleEntity));
        }
        return activeHustles;
    }

    private Hustle getHustle(HustleEntity hustleEntity){
        Hustle hustle =  Hustle.builder()
                .status(hustleEntity.getStatus())
                .name(hustleEntity.getName())
                .valuation(hustleEntity.getValuation())
                .soldCardCount(hustleEntity.getSoldCardCount())
                .totalCapitalRaised(hustleEntity.getTotalCapitalRaised())
                .id(hustleEntity.getId()).sailorId(hustleEntity.getSailorId()).totalCardCount(hustleEntity.getTotalCardCount())
                .cardValue(hustleEntity.getCardValue()).name(hustleEntity.getName()).returnValue(hustleEntity.getReturnValue())
                .currency(hustleEntity.getCurrency()).approvedBy(hustleEntity.getApprovedBy())
                .endDate(hustleEntity.getEndDate()).tenure(hustleEntity.getTenure()).tenureUnit(hustleEntity.getTenureUnit())
                .returnType(hustleEntity.getReturnType()).returnPeriod(hustleEntity.getReturnPeriod())
                .description(hustleEntity.getDescription()).totalReturnPerCard(hustleEntity.getTotalReturnPerCard())
                .createdAt(hustleEntity.getCreatedAt()).updatedAt(hustleEntity.getUpdatedAt()).build();

        hustle.setUnsoldCardCount(hustle.getTotalCardCount() - hustle.getSoldCardCount());
        return hustle;
    }
}
