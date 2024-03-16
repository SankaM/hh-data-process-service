package com.hustlehub.dataservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Wallet {
    private String walletId;
    @JsonIgnore
    private String voyagerId;
    private String currency;
    private BigDecimal balance;
    private Status status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
