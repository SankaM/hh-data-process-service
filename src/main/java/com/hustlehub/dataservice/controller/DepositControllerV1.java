package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.DepositRequest;
import com.hustlehub.dataservice.service.DepositService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
