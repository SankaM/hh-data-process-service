package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;

import java.util.UUID;

public interface VoyagerService {

    CreateVoyagerResponse createVoyager(CreateVoyagerRequest createVoyagerRequest);

    Voyager getVoyager(UUID id);

}
