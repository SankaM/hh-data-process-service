package com.hustlehub.dataservice.controller;

import com.hustlehub.dataservice.dto.Hustle;
import com.hustlehub.dataservice.dto.Sailor;
import com.hustlehub.dataservice.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AdminControllerV1Test {

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminControllerV1 adminControllerV1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testApproveSailor() {
        String sailorId = "123";
        Sailor sailor = new Sailor();
        when(adminService.approveSailor(sailorId)).thenReturn(sailor);

        Sailor result = adminControllerV1.approveSailor(sailorId);

        assertEquals(sailor, result);
        verify(adminService, times(1)).approveSailor(sailorId);
    }

    @Test
    void testApproveHustle() {
        String sailorId = "123";
        String hustleId = "456";
        Hustle hustle = new Hustle();
        when(adminService.approveHustle(sailorId, hustleId)).thenReturn(hustle);

        Hustle result = adminControllerV1.approveSailor(sailorId, hustleId);

        assertEquals(hustle, result);
        verify(adminService, times(1)).approveHustle(sailorId, hustleId);
    }

    @Test
    void testStartApprovedHustleJob() {
        doNothing().when(adminService).startApprovedHustles();

        ResponseEntity response = adminControllerV1.startApprovedHustleJob();

        assertEquals(ResponseEntity.noContent().build(), response);
        verify(adminService, times(1)).startApprovedHustles();
    }
}