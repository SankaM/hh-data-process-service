package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;

import java.util.UUID;

public interface SailorService {

    CreateSailorResponse createSailor(CreateMerchantRequest createMerchantRequest);

    Sailor getSailor(UUID id);

}
