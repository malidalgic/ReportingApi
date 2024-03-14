package com.guardian.reportingapi.dto.response.transaction.report;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response {

    private int count;
    private int total;
    private String currency;
}
