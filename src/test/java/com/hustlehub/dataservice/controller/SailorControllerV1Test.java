package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.CreateHustleRequest;
import com.hustlehub.dataservice.dto.CreateSailorRequest;
import com.hustlehub.dataservice.dto.Hustle;
import com.hustlehub.dataservice.dto.Sailor;
import com.hustlehub.dataservice.service.SailorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SailorControllerV1Test {

    @Mock
    private SailorService sailorService;

    @InjectMocks
    private SailorControllerV1 sailorControllerV1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateSailor() {
        CreateSailorRequest request = new CreateSailorRequest();
        Sailor sailor = new Sailor();
        when(sailorService.createSailor(request)).thenReturn(sailor);

        Sailor result = sailorControllerV1.createSailor(request);

        assertEquals(sailor, result);
        verify(sailorService, times(1)).createSailor(request);
    }

    @Test
    void testGetSailor() {
        String sailorId = "123";
        Sailor sailor = new Sailor();
        when(sailorService.getSailor(sailorId)).thenReturn(sailor);

        Sailor result = sailorControllerV1.getSailor(sailorId);

        assertEquals(sailor, result);
        verify(sailorService, times(1)).getSailor(sailorId);
    }

    @Test
    void testCreateHustle() {
        String sailorId = "123";
        CreateHustleRequest request = new CreateHustleRequest();
        Hustle hustle = new Hustle();
        when(sailorService.createHustle(sailorId, request)).thenReturn(hustle);

        Hustle result = sailorControllerV1.createHustle(sailorId, request);

        assertEquals(hustle, result);
        verify(sailorService, times(1)).createHustle(sailorId, request);
    }

    @Test
    void testListSailorHustles() {
        String sailorId = "123";
        List<Hustle> hustles = Collections.singletonList(new Hustle());
        when(sailorService.listSailorHustles(sailorId)).thenReturn(hustles);

        List<Hustle> result = sailorControllerV1.listSailorHustles(sailorId);

        assertEquals(hustles, result);
        verify(sailorService, times(1)).listSailorHustles(sailorId);
    }
}