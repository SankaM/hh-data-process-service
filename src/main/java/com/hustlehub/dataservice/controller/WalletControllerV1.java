package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.Deposit;
import com.hustlehub.dataservice.dto.DepositRequest;
import com.hustlehub.dataservice.dto.DepositResponse;
import com.hustlehub.dataservice.service.WalletService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/wallet")
public class WalletControllerV1 {

    private final WalletService walletService;

    public WalletControllerV1(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/deposit")
    public void saveDeposit(@RequestBody DepositRequest depositRequest) {
        walletService.createDeposit(depositRequest);
    }

    @GetMapping("/list")
    public DepositResponse viewDeposits() {
        List<Deposit> depositList = walletService.loadAllDeposits();
        DepositResponse response = new DepositResponse();
        response.setDeposits(depositList);
        return response;
    }

}
