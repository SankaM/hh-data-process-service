package com.hustlehub.dataservice.dto;

import lombok.Data;

@Data
public class DepositRequest {
    private String amount;
    private String currency;
}
