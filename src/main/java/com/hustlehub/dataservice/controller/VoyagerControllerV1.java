package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.service.VoyagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/voyager")
public class VoyagerControllerV1 {

    @Autowired
    private VoyagerService voyagerService;


    @PostMapping("/create")
    public Voyager onboardVoyager(@RequestBody CreateVoyagerRequest createMerchantRequest) {
       return  voyagerService.createVoyager(createMerchantRequest);
    }

    @GetMapping("/{id}")
    public Voyager getVoyager(@PathVariable String id) {
        return voyagerService.getVoyager(id);
    }

    @PostMapping("/{voyagerId}/hustle/{hustleId}/amulet")
    public Amulet investHustle(@PathVariable("voyagerId") String voyagerId,
                               @PathVariable("hustleId") String hustleId,
                               @RequestBody CreateAmuletRequest createAmuletRequest) {
        return  voyagerService.createAmulet(voyagerId, hustleId, createAmuletRequest);
    }

    @GetMapping("/{id}/summary")
    public HustleSummary getHustleSummary(@PathVariable String id) {
        return voyagerService.getHustleSummary(id);
    }


}
