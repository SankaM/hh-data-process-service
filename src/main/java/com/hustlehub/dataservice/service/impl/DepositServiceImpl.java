package com.hustlehub.dataservice.service.impl;

import com.hustlehub.dataservice.dto.Deposit;
import com.hustlehub.dataservice.dto.DepositRequest;
import com.hustlehub.dataservice.entity.DepositEntity;
import com.hustlehub.dataservice.mapper.DepositEntityMapper;
import com.hustlehub.dataservice.repository.DepositRepository;
import com.hustlehub.dataservice.service.DepositService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepositServiceImpl implements DepositService {

    private static final Logger log = LoggerFactory.getLogger(DepositServiceImpl.class);

    private final DepositRepository depositRepository;

    private final DepositEntityMapper depositEntityMapper;

    public DepositServiceImpl(DepositRepository depositRepository, DepositEntityMapper depositEntityMapper) {
        this.depositRepository = depositRepository;
        this.depositEntityMapper = depositEntityMapper;
    }

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

    private void validateDepositRequest(DepositRequest depositRequest) {
        if (depositRequest == null || depositRequest.getAmount() == null
                || depositRequest.getCurrency() == null) {
            log.error("Invalid request");
            throw new RuntimeException("Invalid Request");
        }
    }

}
