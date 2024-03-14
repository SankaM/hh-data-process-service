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


    @PostMapping("/sailor/create")
    public CreateSailorResponse createSailor(@RequestBody CreateMerchantRequest createMerchantRequest) {
       return  sailorService.createSailor(createMerchantRequest);
    }

    @GetMapping("/sailor/{id}")
    public Sailor getSailor(@PathVariable UUID id) {
        return sailorService.getSailor(id);
    }

}
