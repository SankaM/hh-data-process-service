package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;

import java.util.List;
import java.util.UUID;

public interface MerchantService {

    CreateMerchantResponse createMerchant(CreateMerchantRequest createMerchantRequest);

    Merchant getMerchant(UUID id);

}
