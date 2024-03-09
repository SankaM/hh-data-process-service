package com.hustlehub.dataservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DepositResponse {
    private List<Deposit> deposits;
}
