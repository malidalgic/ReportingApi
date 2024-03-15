package com.guardian.reportingapi.dto.response.transaction.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.guardian.reportingapi.dto.enumeration.Status;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TransactionReportResponse {

    private Status status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Response> response;
}
