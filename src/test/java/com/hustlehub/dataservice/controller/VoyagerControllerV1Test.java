package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.*;
import com.hustlehub.dataservice.service.VoyagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class VoyagerControllerV1Test {

    @Mock
    private VoyagerService voyagerService;

    @InjectMocks
    private VoyagerControllerV1 voyagerControllerV1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testOnboardVoyager() {
        CreateVoyagerRequest request = new CreateVoyagerRequest();
        Voyager voyager = new Voyager();
        when(voyagerService.createVoyager(request)).thenReturn(voyager);

        Voyager result = voyagerControllerV1.onboardVoyager(request);

        assertEquals(voyager, result);
        verify(voyagerService, times(1)).createVoyager(request);
    }

    @Test
    void testGetVoyager() {
        String voyagerId = "123";
        Voyager voyager = new Voyager();
        when(voyagerService.getVoyager(voyagerId)).thenReturn(voyager);

        Voyager result = voyagerControllerV1.getVoyager(voyagerId);

        assertEquals(voyager, result);
        verify(voyagerService, times(1)).getVoyager(voyagerId);
    }

    @Test
    void testInvestHustle() {
        String voyagerId = "123";
        String hustleId = "456";
        CreateAmuletRequest request = new CreateAmuletRequest();
        Amulet amulet = new Amulet();
        when(voyagerService.createAmulet(voyagerId, hustleId, request)).thenReturn(amulet);

        Amulet result = voyagerControllerV1.investHustle(voyagerId, hustleId, request);

        assertEquals(amulet, result);
        verify(voyagerService, times(1)).createAmulet(voyagerId, hustleId, request);
    }

    @Test
    void testGetHustleSummary() {
        String voyagerId = "123";
        HustleSummary summary = new HustleSummary();
        when(voyagerService.getHustleSummary(voyagerId)).thenReturn(summary);

        HustleSummary result = voyagerControllerV1.getHustleSummary(voyagerId);

        assertEquals(summary, result);
        verify(voyagerService, times(1)).getHustleSummary(voyagerId);
    }
}