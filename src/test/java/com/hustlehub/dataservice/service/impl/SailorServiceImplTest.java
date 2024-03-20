package com.hustlehub.dataservice.service.impl;

import com.hustlehub.dataservice.dto.Hustle;
import com.hustlehub.dataservice.repository.SailorRepository;
import com.hustlehub.dataservice.service.HustleService;
import com.hustlehub.dataservice.util.HustleTestUtil;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;

public class SailorServiceImplTest {

    @InjectMocks
    private SailorServiceImpl sailorService;

    @Mock
    private SailorRepository sailorRepository;

    @Mock
    private HustleService hustleService;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void listSailorHustlesTest() {
        //Given
        List<Hustle> hustleList = HustleTestUtil.getHustleList();
        when(hustleService.getAllHustlesForSailor("sailorId")).thenReturn(hustleList);

        //When
        List<Hustle> result = sailorService.listSailorHustles("sailorId");

        //Then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Hustle hustle = result.get(0);
        Assertions.assertEquals("bfbf9561-3673-4ba1-9325-7d2361bc0fc4", hustle.getId());
        Assertions.assertEquals("admin1", hustle.getApprovedBy());
        Assertions.assertEquals("hustle1", hustle.getName());
        Assertions.assertEquals(BigDecimal.valueOf(10), hustle.getCardValue());
    }

}
