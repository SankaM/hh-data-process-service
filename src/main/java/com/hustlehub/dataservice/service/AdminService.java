package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.CreateHustleRequest;
import com.hustlehub.dataservice.dto.CreateSailorRequest;
import com.hustlehub.dataservice.dto.Hustle;
import com.hustlehub.dataservice.dto.Sailor;

import java.util.UUID;

public interface AdminService {

    Sailor approveSailor(String sailorId);

    Hustle approveHustle(String sailorId, String hustleId);

    void startApprovedHustles();


}
