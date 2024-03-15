package com.guardian.reportingapi.service.client;

import com.guardian.reportingapi.dto.request.client.ClientRequest;
import com.guardian.reportingapi.dto.response.client.ClientResponse;
import com.guardian.reportingapi.dto.response.transaction.list.CustomerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ClientService {
    public ClientResponse processRequest(ClientRequest clientRequest) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        CustomerInfo customerInfo = CustomerInfo.builder()
                .id(1L)
                .createdAt(LocalDateTime.parse("2015-10-09 12:09:10", formatter))
                .updatedAt(LocalDateTime.parse("2015-10-09 12:09:10", formatter))
                .number("401288XXXXXX1881")
                .expiryMonth("6")
                .expiryYear("2017")
                .email("michael@gmail.com")
                .birthday(LocalDateTime.parse("1986-03-20 12:09:10", formatter))
                .billingFirstName("Michael")
                .billingLastName("Kara")
                .billingAddress1("test address")
                .billingCity("Antalya")
                .billingPostcode("07070")
                .billingCountry("TR")
                .shippingFirstName("Michael")
                .shippingLastName("Kara")
                .shippingAddress1("test address")
                .shippingCity("Antalya")
                .shippingPostcode("07070")
                .shippingCountry("TR")
                .build();

        return ClientResponse.builder().customerInfo(customerInfo).build();
    }
}
