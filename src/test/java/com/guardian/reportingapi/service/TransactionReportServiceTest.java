package com.guardian.reportingapi.service;

import com.guardian.reportingapi.dto.request.transaction.TransactionReportRequest;
import com.guardian.reportingapi.dto.response.transaction.report.TransactionReportResponse;
import com.guardian.reportingapi.service.transaction.TransactionReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransactionReportServiceTest {

    @InjectMocks
    private TransactionReportService transactionReportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

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