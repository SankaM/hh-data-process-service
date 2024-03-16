package com.hustlehub.dataservice.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Voyager {
    private String id;
    private String userName;
    private String name;
    private Status status;
    private List<Wallet> wallets;
}
