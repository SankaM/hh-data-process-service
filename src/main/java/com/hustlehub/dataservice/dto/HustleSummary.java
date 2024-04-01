package com.hustlehub.dataservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HustleSummary {
    private int totalAmulets;
    private BigDecimal totalInvestmentsInAmulets;
    private BigDecimal totalReturnsToDate;
    private BigDecimal totalWithdrawal;
    private BigDecimal totalAmountEligibleToWithdraw;
    private List<AmuletSummary> amulets;
}
