package com.guardian.reportingapi.dto.request.transaction;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@Builder
public class TransactionRequest {

    @NotNull
    private String transactionId;
}
