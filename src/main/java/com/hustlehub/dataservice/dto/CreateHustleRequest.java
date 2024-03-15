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
public class CreateHustleRequest {

    private String name;
    private String description;
    private BigDecimal valuation;
    private String currency;
    private Long cardCount;
    private BigDecimal cardValue;
    private Long tenure;
    private String tenureUnit;
    private String returnPeriod;
    private String returnType;
    private Long returnValue;
}
