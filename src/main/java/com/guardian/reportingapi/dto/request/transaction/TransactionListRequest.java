package com.guardian.reportingapi.dto.request.transaction;

import com.guardian.reportingapi.dto.ErrorCode;
import com.guardian.reportingapi.dto.FilterField;
import com.guardian.reportingapi.dto.Operation;
import com.guardian.reportingapi.dto.enumeration.PaymentMethod;
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
    private Operation operation;
    private Long merchantId;
    private Long acquirerId;
    private PaymentMethod paymentMethod;
    private ErrorCode errorCode;
    private FilterField filterField;
    private String filterValue;
    private int page;
}
