package com.guardian.reportingapi.service.transaction;

import com.guardian.reportingapi.dto.request.transaction.report.TransactionReportRequest;
import com.guardian.reportingapi.dto.response.transaction.report.TransactionReportResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransactionReportServiceTest {

    private final TransactionReportService transactionReportService = new TransactionReportService();

    @Test
    void whenValidRequest_thenReturnsExpectedResponse() {
        TransactionReportRequest request = generateRequest();

        TransactionReportResponse response = transactionReportService.fetchTransactionReport(request);

        assertNotNull(response);
    }

    private TransactionReportRequest generateRequest() {
        return TransactionReportRequest.builder()
                .fromDate(LocalDate.of(2015, 7, 1))
                .toDate(LocalDate.of(2015, 10, 1))
                .merchant(1L)
                .acquirer(1L)
                .build();
    }
}