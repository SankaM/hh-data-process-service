package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.DepositRequest;

public interface DepositService {
    Boolean createDeposit(DepositRequest depositRequest);
}
