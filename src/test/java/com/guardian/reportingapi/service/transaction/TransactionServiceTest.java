package com.guardian.reportingapi.service.transaction;

import com.guardian.reportingapi.dto.request.transaction.TransactionRequest;
import com.guardian.reportingapi.dto.response.transaction.TransactionResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransactionServiceTest {

    private final TransactionService transactionService = new TransactionService();

    @Test
    void processRequest() {
        TransactionRequest request = TransactionRequest.builder()
                .transactionId("testTransactionId")
                .build();

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