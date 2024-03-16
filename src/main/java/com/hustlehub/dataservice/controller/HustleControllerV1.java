package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.service.HustleService;
import com.hustlehub.dataservice.service.SailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/hustles")
public class HustleControllerV1 {

    @Autowired
    private HustleService hustleService;



    @GetMapping("/{id}")
    public Hustle getHustle(@PathVariable String id) {
        return hustleService.getHustle(id);
    }

    @GetMapping("/active")
    public List<Hustle> getActiveHustles() {
        return hustleService.getActiveHustles();
    }

}
