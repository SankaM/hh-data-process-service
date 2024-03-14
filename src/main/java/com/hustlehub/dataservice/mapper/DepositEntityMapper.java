package com.hustlehub.dataservice.mapper;

import com.hustlehub.dataservice.core.AbstractModelAdaptor;
import com.hustlehub.dataservice.dto.Deposit;
import com.hustlehub.dataservice.dto.DepositRequest;
import com.hustlehub.dataservice.dto.Status;
import com.hustlehub.dataservice.entity.DepositEntity;
import com.hustlehub.dataservice.dto.PaymentType;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class DepositEntityMapper extends AbstractModelAdaptor<DepositEntity, Deposit> {

    public DepositEntityMapper() {
        super(DepositEntity.class, Deposit.class);
    }

    @Override
    protected PropertyMap<DepositEntity, Deposit> fromModelMappings() {
        return new PropertyMap<>() {
            @Override
            protected void configure() {
            }
        };
    }

    @Override
    protected PropertyMap<Deposit, DepositEntity> fromDtoMappings() {
        return new PropertyMap<>() {
            @Override
            protected void configure() {
            }
        };
    }

    @Override
    public List<Deposit> fromModelList(List<DepositEntity> depositEntities) {
        return super.fromModelList(depositEntities);
    }

    @Override
    public Deposit fromModel(DepositEntity document) {
        Deposit deposit = super.fromModel(document);
        deposit.setAmount(String.valueOf(document.getAmount()));
        deposit.setCreatedDate(document.getCreatedDate().format(DateTimeFormatter.ISO_DATE));
        deposit.setUpdatedDate(document.getUpdatedDate() != null ? document.getUpdatedDate().format(DateTimeFormatter.ISO_DATE) : "");
        return deposit;
    }

    public DepositEntity mapToDepositEntity(DepositRequest depositRequest) {
        DepositEntity depositEntity = new DepositEntity();
        BigDecimal amount = BigDecimal.valueOf(Long.parseLong(depositRequest.getAmount()));
        depositEntity.setAmount(amount);
        depositEntity.setCurrency(depositRequest.getCurrency());
        depositEntity.setStatus(Status.PENDING);
        depositEntity.setCountry("SG");
        depositEntity.setCreatedDate(LocalDateTime.now());
        depositEntity.setUserId("dummy_user");
        depositEntity.setPaymentType(PaymentType.BANK_TRANSFER);
        return depositEntity;
    }
}
