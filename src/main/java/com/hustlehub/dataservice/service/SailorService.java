package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;

import java.util.UUID;

public interface SailorService {

    CreateSailorResponse createMerchant(CreateMerchantRequest createMerchantRequest);

    Sailor getMerchant(UUID id);

}
