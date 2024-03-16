package com.hustlehub.dataservice.service.impl;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.entity.*;
import com.hustlehub.dataservice.repository.AmuletRepository;
import com.hustlehub.dataservice.repository.VoyagerRepository;
import com.hustlehub.dataservice.service.HustleService;
import com.hustlehub.dataservice.service.VoyagerService;
import com.hustlehub.dataservice.service.WalletService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;


@Service
public class VoyagerServiceImpl implements VoyagerService {

    private static final Logger log = LoggerFactory.getLogger(VoyagerServiceImpl.class);

    @Autowired
    private VoyagerRepository voyagerRepository;

    @Autowired
    private AmuletRepository amuletRepository;

    @Autowired
    private WalletService walletService;

    @Autowired
    private HustleService hustleService;


    @Transactional
    @Override
    public Voyager createVoyager(CreateVoyagerRequest createVoyagerRequest) {
        VoyagerEntity voyagerEntity = VoyagerEntity.builder()
                .id(UUID.randomUUID().toString())
                .status(createVoyagerRequest.getInitialBalance().compareTo(BigDecimal.ZERO)>0?Status.ACTIVE:Status.INITIATED)
                .name(createVoyagerRequest.getName())
                .userName(createVoyagerRequest.getUserName()).build();
        voyagerEntity = voyagerRepository.save(voyagerEntity);
        // create wallet with and currency
        Wallet  wallet = walletService.createWallet(voyagerEntity.getId(), "SGD",createVoyagerRequest.getInitialBalance());
        log.info("Created voyager in the system");
        return Voyager.builder().userName(voyagerEntity.getUserName()).name(voyagerEntity.getName())
                .status(voyagerEntity.getStatus())
                .id(voyagerEntity.getId()).wallet(wallet).build();
    }

    @Override
    public Voyager getVoyager(String id){
        VoyagerEntity voyagerEntity =  voyagerRepository.findById(id).get();
        return Voyager.builder().userName(voyagerEntity.getUserName()).name(voyagerEntity.getName())
                .status(voyagerEntity.getStatus())
                .id(voyagerEntity.getId()).build();
    }

    @Override
    public Amulet  createAmulet(String voyagerId, String hustleId, CreateAmuletRequest createAmuletRequest){
        HustleEntity hustleEntity = hustleService.getHustleEntity(hustleId);
        //Logic to update hustle
        hustleEntity.setSoldCardCount(hustleEntity.getSoldCardCount()+ createAmuletRequest.getPurchasedCardCount());
        hustleEntity.setTotalCapitalRaised(hustleEntity.getTotalCapitalRaised().add(createAmuletRequest.getInvestedAmount()));
        hustleService.saveHustleEntity(hustleEntity);
        // create amulet
        AmuletEntity amuletEntity = AmuletEntity.builder()
                .purchasedCardCount(createAmuletRequest.getPurchasedCardCount())
                .cardValue(hustleEntity.getCardValue())
                .hustleId(hustleId)
                .voyagerId(voyagerId)
                .investedAmount(createAmuletRequest.getInvestedAmount())
                .currentTotalReturnReceived(BigDecimal.ZERO)
                .status(Status.INITIATED)
                .totalReturnExpected(
                        hustleEntity.getTotalReturnPerCard().multiply(new BigDecimal(createAmuletRequest.getPurchasedCardCount())))
                .build();
        amuletEntity = amuletRepository.save(amuletEntity);
        Amulet amulet = Amulet.builder()
                .hustleId(amuletEntity.getHustleId())
                .voyagerId(amuletEntity.getVoyagerId())
                .investedAmount(amuletEntity.getInvestedAmount())
                .purchasedCardCount(amuletEntity.getPurchasedCardCount())
                .currentTotalReturnReceived(amuletEntity.getCurrentTotalReturnReceived())
                .status(amuletEntity.getStatus())
                .cardValue(amuletEntity.getCardValue())
                .nextReturnAmount(amuletEntity.getNextReturnAmount())
                .totalReturnExpected(amuletEntity.getTotalReturnExpected())
                .nextReturnDate(amuletEntity.getNextReturnDate())
                .startDate(amuletEntity.getStartDate())
                .endDate(amuletEntity.getEndDate()).build();
        BigDecimal returnPercentage  = amuletEntity.getTotalReturnExpected().divide(amuletEntity.getInvestedAmount()).multiply(new BigDecimal("100"));
        amulet.setTotalReturnPercentage(returnPercentage.toString()+"%");
        return amulet;
    }
}
