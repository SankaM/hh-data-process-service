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
    private UUID id;
    private String userName;
    private String ticker;
    private List<Hustle> hustles;
    private String approvedBy;
}
