package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;

import java.util.List;
import java.util.UUID;

public interface SailorService {

    Sailor createSailor(CreateSailorRequest createSailorRequest);

    Sailor getSailor(String id);

    Hustle createHustle(String sailorId, CreateHustleRequest createHustleRequest);

    List<Hustle> listSailorHustles(String id);
}
