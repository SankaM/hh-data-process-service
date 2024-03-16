package com.hustlehub.dataservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class Amulet {

    private String voyagerId;
    private String hustleId;
    private BigDecimal investedAmount;
    private Long purchasedCardCount;
    private BigDecimal cardValue;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime nextReturnDate;
    private BigDecimal nextReturnAmount;
    private BigDecimal currentTotalReturnReceived;
    private BigDecimal totalReturnExpected;
    private String totalReturnPercentage;
    private Status status;
}
