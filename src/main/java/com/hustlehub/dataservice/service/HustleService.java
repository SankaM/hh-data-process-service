package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.entity.HustleEntity;

import java.util.List;
import java.util.UUID;

public interface HustleService {

    Hustle createHustle(String sailorId, CreateHustleRequest createHustleRequest);

    Hustle getHustle(String id);

    HustleEntity getHustleEntity(String id);

    HustleEntity saveHustleEntity(HustleEntity hustleEntity);

    List<Hustle> getActiveHustles();

}
