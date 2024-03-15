package com.guardian.reportingapi.dto.request.transaction.list;

import com.guardian.reportingapi.dto.enumeration.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class TransactionListRequest {

    private LocalDate fromDate;
    private LocalDate toDate;
    private Status status;
    private String operation;
    private Long merchantId;
    private Long acquirerId;
    private String paymentMethod;
    private String errorCode;
    private String filterField;
    private String filterValue;
    private int page;
}
