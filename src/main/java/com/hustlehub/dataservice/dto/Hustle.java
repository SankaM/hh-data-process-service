package com.hustlehub.dataservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hustle {
    private String id;
    private String name;
    private String description;
    private String sailorId;
    private Status status;
    private BigDecimal valuation;
    private String currency;
    private Long cardCount;
    private BigDecimal cardValue;
    private String approvedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long tenure;
    private String tenureUnit;
    private String returnPeriod;
    private String returnType;
    private Long returnValue;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
