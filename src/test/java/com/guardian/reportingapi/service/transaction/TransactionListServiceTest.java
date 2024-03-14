package com.guardian.reportingapi.service.transaction;

import com.guardian.reportingapi.dto.request.transaction.TransactionListRequest;
import com.guardian.reportingapi.dto.response.transaction.list.TransactionListResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransactionListServiceTest {

    @InjectMocks
    private TransactionListService transactionListService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenValidRequest_thenReturnsExpectedResponse() {
        TransactionListRequest request = generateRequest();

        TransactionListResponse response = transactionListService.fetchTransactionList(request);

        assertNotNull(response);
    }

    private TransactionListRequest generateRequest() {
        return TransactionListRequest.builder()
                .fromDate(LocalDate.of(2015, 7, 1))
                .toDate(LocalDate.of(2015, 10, 1))
                .build();
    }
}