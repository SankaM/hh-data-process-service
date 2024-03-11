package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.service.DepositService;
import com.hustlehub.dataservice.service.MerchantService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/data")
public class MerchantControllerV1 {

    @Autowired
    private  MerchantService merchantService;


    @PostMapping("/merchant/create")
    public CreateMerchantResponse createMerchant(@RequestBody CreateMerchantRequest createMerchantRequest) {
       return  merchantService.createMerchant(createMerchantRequest);
    }

    @GetMapping("/merchant/{id}")
    public Merchant getMerchant(@PathVariable UUID id) {
        return merchantService.getMerchant(id);
    }

}
