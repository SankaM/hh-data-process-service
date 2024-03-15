package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.Deposit;
import com.hustlehub.dataservice.dto.DepositRequest;

import java.util.List;

public interface WalletService {
    Boolean createDeposit(DepositRequest depositRequest);

    List<Deposit> loadAllDeposits();
}
