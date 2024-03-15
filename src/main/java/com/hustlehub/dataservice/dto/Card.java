package com.hustlehub.dataservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private UUID id;
    private String hustleId;
    private BigDecimal cardValue;
    private String currency;
}
