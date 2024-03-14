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
public class HustleControllerV1 {

    @Autowired
    private SailorService sailorService;


    @PostMapping("/hustle/create")
    public CreateSailorResponse createHustle(@RequestBody CreateMerchantRequest createMerchantRequest) {
       return  sailorService.createSailor(createMerchantRequest);
    }

    @GetMapping("/hustle/{id}")
    public Sailor getHustle(@PathVariable UUID id) {
        return sailorService.getSailor(id);
    }

}
