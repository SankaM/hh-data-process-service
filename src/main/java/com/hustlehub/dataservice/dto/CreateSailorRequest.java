package com.hustlehub.dataservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class CreateSailorRequest {

    private String userName;
    private String name;
    private String sector;
    private String tag;
}
