package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.Deposit;
import com.hustlehub.dataservice.dto.DepositRequest;
import com.hustlehub.dataservice.dto.DepositResponse;
import com.hustlehub.dataservice.service.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WalletControllerV1Test {

    @Mock
    private WalletService walletService;

    @InjectMocks
    private WalletControllerV1 walletControllerV1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveDeposit() {
        DepositRequest depositRequest = new DepositRequest();
        when(walletService.createDeposit(depositRequest)).thenReturn(true);

        walletControllerV1.saveDeposit(depositRequest);

        verify(walletService, times(1)).createDeposit(depositRequest);
    }

    @Test
    void testViewDeposits() {
        List<Deposit> depositList = Collections.singletonList(new Deposit());
        when(walletService.loadAllDeposits()).thenReturn(depositList);

        DepositResponse response = walletControllerV1.viewDeposits();

        assertEquals(depositList, response.getDeposits());
        verify(walletService, times(1)).loadAllDeposits();
    }
}