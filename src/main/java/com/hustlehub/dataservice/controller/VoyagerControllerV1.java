package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.CreateMerchantRequest;
import com.hustlehub.dataservice.dto.CreateSailorResponse;
import com.hustlehub.dataservice.dto.Sailor;
import com.hustlehub.dataservice.service.SailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/data")
public class VoyagerControllerV1 {

    @Autowired
    private SailorService sailorService;


    @PostMapping("/hustler/create")
    public CreateSailorResponse onboardHustler(@RequestBody CreateMerchantRequest createMerchantRequest) {
       return  sailorService.createMerchant(createMerchantRequest);
    }

    @GetMapping("/hustler/{id}")
    public Sailor getHustler(@PathVariable UUID id) {
        return sailorService.getMerchant(id);
    }

}
