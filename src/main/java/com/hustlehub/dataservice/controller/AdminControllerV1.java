package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.CreateSailorRequest;
import com.hustlehub.dataservice.dto.Sailor;
import com.hustlehub.dataservice.service.AdminService;
import com.hustlehub.dataservice.service.SailorService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
