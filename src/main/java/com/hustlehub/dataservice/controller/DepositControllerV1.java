package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.Deposit;
import com.hustlehub.dataservice.dto.DepositRequest;
import com.hustlehub.dataservice.dto.DepositResponse;
import com.hustlehub.dataservice.service.DepositService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/data")
public class DepositControllerV1 {

    private final DepositService depositService;

    public DepositControllerV1(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/deposit")
    public void saveDeposit(@RequestBody DepositRequest depositRequest) {
        depositService.createDeposit(depositRequest);
    }

    @GetMapping("/deposit")
    public DepositResponse viewDeposits() {
        List<Deposit> depositList = depositService.loadAllDeposits();
        DepositResponse response = new DepositResponse();
        response.setDeposits(depositList);
        return response;
    }

}
