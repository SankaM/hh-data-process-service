package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.CreateSailorRequest;
import com.hustlehub.dataservice.dto.Sailor;

import java.util.UUID;

public interface AdminService {

    Sailor approveSailor(String sailorId);

}
