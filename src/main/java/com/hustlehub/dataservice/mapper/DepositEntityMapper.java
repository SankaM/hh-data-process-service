package com.hustlehub.dataservice.mapper;

import com.hustlehub.dataservice.dto.DepositRequest;
import com.hustlehub.dataservice.entity.DepositEntity;
import com.hustlehub.dataservice.entity.DepositStatus;
import com.hustlehub.dataservice.entity.PaymentType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DepositEntityMapper {

    public DepositEntity mapToDepositEntity(DepositRequest depositRequest) {
        DepositEntity depositEntity = new DepositEntity();
        BigDecimal amount = BigDecimal.valueOf(Long.parseLong(depositRequest.getAmount()));
        depositEntity.setAmount(amount);
        depositEntity.setCurrency(depositRequest.getCurrency());
        depositEntity.setStatus(DepositStatus.PENDING);
        depositEntity.setCountry("SG");
        depositEntity.setCreatedDate(LocalDateTime.now());
        depositEntity.setUserId("dummy_user");
        depositEntity.setPaymentType(PaymentType.BANK_TRANSFER);
        return depositEntity;
    }
}
