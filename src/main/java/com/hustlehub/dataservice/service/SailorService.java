package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;

import java.util.UUID;

public interface SailorService {

    Sailor createSailor(CreateSailorRequest createSailorRequest);

    Sailor getSailor(UUID id);

}
