package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;

import java.util.UUID;

public interface HustleService {

    Hustle createHustle(CreateHustleRequest createHustleRequest);

    Hustle getHustle(String id);

}
