package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.Deposit;
import com.hustlehub.dataservice.dto.DepositRequest;
import com.hustlehub.dataservice.dto.Wallet;

import java.math.BigDecimal;
import java.util.List;

public interface WalletService {
    Boolean createDeposit(DepositRequest depositRequest);

    List<Deposit> loadAllDeposits();

    Wallet createWallet(String voyagerId, String currency, BigDecimal initialBalance);
}
