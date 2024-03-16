package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.CreateHustleRequest;
import com.hustlehub.dataservice.dto.CreateSailorRequest;
import com.hustlehub.dataservice.dto.Hustle;
import com.hustlehub.dataservice.dto.Sailor;
import com.hustlehub.dataservice.service.AdminService;
import com.hustlehub.dataservice.service.SailorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/admin")
public class AdminControllerV1 {

    @Autowired
    private AdminService adminService;


    @PutMapping("/sailor/{id}/approve")
    public Sailor approveSailor(@PathVariable("id") String id) {
       return  adminService.approveSailor(id);
    }

    @PutMapping("/sailor/{sailorId}/hustle/{hustleId}/approve")
    public Hustle approveSailor(@PathVariable("sailorId") String sailorId, @PathVariable("hustleId") String hustleId) {
        return  adminService.approveHustle(sailorId, hustleId);
    }

    @PutMapping("/job/hustles/activate")
    public ResponseEntity startApprovedHustleJob() {
        adminService.startApprovedHustles();
        return ResponseEntity.noContent().build();
    }
}
