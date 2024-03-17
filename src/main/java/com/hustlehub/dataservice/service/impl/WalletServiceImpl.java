package com.hustlehub.dataservice.service.impl;

import com.hustlehub.dataservice.dto.Deposit;
import com.hustlehub.dataservice.dto.DepositRequest;
import com.hustlehub.dataservice.dto.Status;
import com.hustlehub.dataservice.dto.Wallet;
import com.hustlehub.dataservice.entity.DepositEntity;
import com.hustlehub.dataservice.entity.WalletEntity;
import com.hustlehub.dataservice.mapper.DepositEntityMapper;
import com.hustlehub.dataservice.repository.DepositRepository;
import com.hustlehub.dataservice.repository.WalletRepository;
import com.hustlehub.dataservice.service.WalletService;
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
public class WalletServiceImpl implements WalletService {

    private static final Logger log = LoggerFactory.getLogger(WalletServiceImpl.class);

    @Autowired
    private  DepositRepository depositRepository;

    @Autowired
    private WalletRepository walletRepository;


    @Autowired
    private  DepositEntityMapper depositEntityMapper;

    @Transactional
    @Override
    public Boolean createDeposit(DepositRequest depositRequest) {
        validateDepositRequest(depositRequest);
        DepositEntity depositEntity = depositEntityMapper.mapToDepositEntity(depositRequest);
        depositRepository.save(depositEntity);
        log.info("Created deposits in the system");
        return Boolean.TRUE;
    }

    @Override
    public List<Deposit> loadAllDeposits() {
        List<DepositEntity> depositEntities =  depositRepository.findAll();
        log.info("Loaded all the deposits for user");
        return depositEntityMapper.fromModelList(depositEntities);
    }

    @Override
    public List<Wallet> findWalletByVoyagerId(String voyagerId) {
        List<WalletEntity> walletEntities =  walletRepository.findWalletByVoyagerId(voyagerId);
        List<Wallet> wallets = new ArrayList<>();
        for(WalletEntity walletEntity: walletEntities){
            wallets.add(getWallet(walletEntity));
        }
        return wallets;
    }

    @Override
    public  WalletEntity getWalletEntityByWalletId(String walletId){
        return walletRepository.findById(walletId).get();
    }

    @Override
    public Wallet createWallet(String voyagerId, String currency, BigDecimal initialBalance ) {
        WalletEntity walletEntity = walletRepository.save(WalletEntity.builder()
                .balance(initialBalance)
                .id(UUID.randomUUID().toString())
                .status(initialBalance.compareTo(BigDecimal.ZERO) > 0 ? Status.ACTIVE : Status.INACTIVE)
                .voyagerId(voyagerId)
                .currency(currency)
                .build());
        return getWallet(walletEntity);
    }

    @Override
    public WalletEntity updateWallet(WalletEntity walletEntity){
        return walletRepository.save(walletEntity);
    }

    private Wallet getWallet(WalletEntity walletEntity){
        return Wallet.builder().walletId(walletEntity.getId()).balance(walletEntity.getBalance())
                .currency(walletEntity.getCurrency())
                .status(walletEntity.getStatus())
                .voyagerId(walletEntity.getVoyagerId()).build();
    }

    private void validateDepositRequest(DepositRequest depositRequest) {
        if (depositRequest == null || depositRequest.getAmount() == null
                || depositRequest.getCurrency() == null) {
            log.error("Invalid request");
            throw new RuntimeException("Invalid Request");
        }
    }

}
