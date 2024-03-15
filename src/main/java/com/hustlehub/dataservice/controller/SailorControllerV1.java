package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.service.SailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/sailor")
public class SailorControllerV1 {

    @Autowired
    private SailorService sailorService;


    @PostMapping("/create")
    public Sailor createSailor(@RequestBody CreateSailorRequest createSailorRequest) {
       return  sailorService.createSailor(createSailorRequest);
    }

    @GetMapping("/{id}")
    public Sailor getSailor(@PathVariable UUID id) {
        return sailorService.getSailor(id);
    }

}
