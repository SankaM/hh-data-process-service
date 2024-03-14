package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.service.SailorService;
import com.hustlehub.dataservice.service.VoyagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/data")
public class VoyagerControllerV1 {

    @Autowired
    private VoyagerService voyagerService;


    @PostMapping("/voyager/create")
    public CreateVoyagerResponse onboardVoyager(@RequestBody CreateVoyagerRequest createMerchantRequest) {
       return  voyagerService.createVoyager(createMerchantRequest);
    }

    @GetMapping("/voyager/{id}")
    public Voyager getHustler(@PathVariable UUID id) {
        return voyagerService.getVoyager(id);
    }

}
