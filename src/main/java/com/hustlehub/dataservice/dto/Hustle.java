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
    private UUID id;
    private String name;
    private String description;
    private String merchantId;
    private Status status;
    private BigDecimal totalInvestment;
    private Long cardCount;
    private List<Card> cards;
    private String currency;
    private String approvedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiredBy;
}
