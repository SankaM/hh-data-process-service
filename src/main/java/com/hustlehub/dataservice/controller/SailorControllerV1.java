package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.service.SailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/data")
public class SailorControllerV1 {

    @Autowired
    private SailorService sailorService;


    @PostMapping("/merchant/create")
    public CreateSailorResponse createMerchant(@RequestBody CreateMerchantRequest createMerchantRequest) {
       return  sailorService.createMerchant(createMerchantRequest);
    }

    @GetMapping("/merchant/{id}")
    public Sailor getMerchant(@PathVariable UUID id) {
        return sailorService.getMerchant(id);
    }

}
