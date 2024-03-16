package com.hustlehub.dataservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CreateAmuletRequest {

    private String hustleId;
    private BigDecimal investedAmount;
    private Long purchasedCardCount;
}
