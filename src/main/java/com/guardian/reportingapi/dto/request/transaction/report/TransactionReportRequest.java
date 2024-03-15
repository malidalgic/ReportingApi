package com.guardian.reportingapi.dto.request.transaction.report;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Getter
@Builder
public class TransactionReportRequest {

    @NotNull
    private LocalDate fromDate;
    @NotNull
    private LocalDate toDate;
    private Long merchant;
    private Long acquirer;
}
