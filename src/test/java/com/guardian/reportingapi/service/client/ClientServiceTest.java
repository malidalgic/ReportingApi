package com.guardian.reportingapi.service.client;

import com.guardian.reportingapi.dto.request.client.ClientRequest;
import com.guardian.reportingapi.dto.response.client.ClientResponse;
import com.guardian.reportingapi.dto.response.transaction.list.CustomerInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClientServiceTest {

    private final ClientService clientService = new ClientService();

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