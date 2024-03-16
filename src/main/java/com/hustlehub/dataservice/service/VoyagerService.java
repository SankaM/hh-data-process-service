package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;

public interface VoyagerService {

    Voyager createVoyager(CreateVoyagerRequest createVoyagerRequest);

    Voyager getVoyager(String id);

    Amulet createAmulet(String voyagerId, String hustleId, CreateAmuletRequest createAmuletRequest);

}
