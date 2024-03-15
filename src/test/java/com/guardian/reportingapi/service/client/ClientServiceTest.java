package com.guardian.reportingapi.service.client;

import com.guardian.reportingapi.dto.request.client.ClientRequest;
import com.guardian.reportingapi.dto.response.client.ClientResponse;
import com.guardian.reportingapi.dto.response.transaction.list.CustomerInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processRequest() {
        ClientRequest clientRequest = ClientRequest.builder()
                .transactionId("testTransactionId")
                .build();

        ClientResponse response = clientService.processRequest(clientRequest);

        assertNotNull(response);

        CustomerInfo customerInfo = response.getCustomerInfo();
        assertNotNull(customerInfo);
        assertEquals(1L, customerInfo.getId());
        assertEquals("michael@gmail.com", customerInfo.getEmail());
    }

}