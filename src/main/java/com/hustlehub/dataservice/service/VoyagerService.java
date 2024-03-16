package com.hustlehub.dataservice.service;

import com.hustlehub.dataservice.dto.*;

import java.util.UUID;

public interface VoyagerService {

    Voyager createVoyager(CreateVoyagerRequest createVoyagerRequest);

    Voyager getVoyager(String id);

}
