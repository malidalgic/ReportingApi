package com.guardian.reportingapi.service.transaction;

import com.guardian.reportingapi.dto.request.transaction.TransactionRequest;
import com.guardian.reportingapi.dto.response.transaction.TransactionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processRequest() {
        TransactionRequest request = new TransactionRequest();
        request.setTransactionId("testTransactionId");

        TransactionResponse response = transactionService.processRequest(request);

        assertNotNull(response);
        assertNotNull(response.getFx());
        assertNotNull(response.getCustomerInfo());
        assertNotNull(response.getMerchant());
        assertNotNull(response.getTransaction());

        assertEquals("Dev-Merchant", response.getMerchant().getName());
        assertEquals("Michael", response.getCustomerInfo().getBillingFirstName());
    }
}