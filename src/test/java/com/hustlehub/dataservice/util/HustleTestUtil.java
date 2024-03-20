package com.hustlehub.dataservice.util;

import com.hustlehub.dataservice.dto.Hustle;

import java.math.BigDecimal;
import java.util.List;

public class HustleTestUtil {
    public static List<Hustle> getHustleList() {
        Hustle hustle = Hustle.builder()
                .id("bfbf9561-3673-4ba1-9325-7d2361bc0fc4")
                .approvedBy("admin1")
                .cardValue(BigDecimal.valueOf(10))
                .currency("SGD")
                .name("hustle1")
                .build();
        return List.of(hustle);
    }
}
