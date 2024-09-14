package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.Hustle;
import com.hustlehub.dataservice.service.HustleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HustleControllerV1Test {

    @Mock
    private HustleService hustleService;

    @InjectMocks
    private HustleControllerV1 hustleControllerV1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetHustle() {
        String hustleId = "123";
        Hustle hustle = new Hustle();
        when(hustleService.getHustle(hustleId)).thenReturn(hustle);

        Hustle result = hustleControllerV1.getHustle(hustleId);

        assertEquals(hustle, result);
        verify(hustleService, times(1)).getHustle(hustleId);
    }

    @Test
    void testGetActiveHustles() {
        List<Hustle> hustles = Collections.singletonList(new Hustle());
        when(hustleService.getActiveHustles()).thenReturn(hustles);

        List<Hustle> result = hustleControllerV1.getActiveHustles();

        assertEquals(hustles, result);
        verify(hustleService, times(1)).getActiveHustles();
    }
}