package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.entity.HustleEntity;

import java.util.List;

public interface HustleService {

    Hustle createHustle(String sailorId, CreateHustleRequest createHustleRequest);

    Hustle getHustle(String id);

    HustleEntity getHustleEntity(String id);

    HustleEntity saveHustleEntity(HustleEntity hustleEntity);

    List<Hustle> getActiveHustles();

    List<Hustle> getAllHustlesForSailor(String sailorId);
}
