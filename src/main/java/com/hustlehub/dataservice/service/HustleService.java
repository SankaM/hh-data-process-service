package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;

import java.util.List;
import java.util.UUID;

public interface HustleService {

    Hustle createHustle(String sailorId, CreateHustleRequest createHustleRequest);

    Hustle getHustle(String id);

    List<Hustle> getActiveHustles();

}
