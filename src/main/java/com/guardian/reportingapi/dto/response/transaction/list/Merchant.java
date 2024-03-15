package com.guardian.reportingapi.dto.response.transaction.list;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Merchant {

    private Long id;
    private String name;
}

