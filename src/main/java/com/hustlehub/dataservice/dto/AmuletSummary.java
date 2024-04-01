package com.hustlehub.dataservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmuletSummary {
    private String amuletId;
    private String name;
    private BigDecimal investedAmount;
    private BigDecimal currentTotalReturnReceived;
    private BigDecimal totalReturnExpected;
    private BigDecimal amountEligibleToWithdraw;
}
