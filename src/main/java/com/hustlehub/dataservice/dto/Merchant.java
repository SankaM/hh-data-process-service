package com.hustlehub.dataservice.dto;

import com.hustlehub.dataservice.entity.DepositStatus;
import com.hustlehub.dataservice.entity.PaymentType;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {
    private UUID id;
    private String userName;
    private DepositStatus status;
    private String approvedBy;
}
