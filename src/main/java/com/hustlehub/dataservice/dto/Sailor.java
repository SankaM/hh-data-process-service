package com.hustlehub.dataservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sailor {
    private UUID id;
    private String userName;
    private String tag;
    private List<Hustle> hustles;
    private String approvedBy;
    private Status status;
}
