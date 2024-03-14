package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.service.HustleService;
import com.hustlehub.dataservice.service.SailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/data")
public class HustleControllerV1 {

    @Autowired
    private HustleService hustleService;


    @PostMapping("/hustle/create")
    public Hustle createHustle(@RequestBody CreateHustleRequest createHustleRequest) {
       return  hustleService.createHustle(createHustleRequest);
    }

    @GetMapping("/hustle/{id}")
    public Hustle getHustle(@PathVariable String id) {
        return hustleService.getHustle(id);
    }

}
