package com.guardian.reportingapi.service.transaction;

import com.guardian.reportingapi.dto.enumeration.Status;
import com.guardian.reportingapi.dto.request.transaction.TransactionRequest;
import com.guardian.reportingapi.dto.response.transaction.MerchantTransactionInfo;
import com.guardian.reportingapi.dto.response.transaction.TransactionResponse;
import com.guardian.reportingapi.dto.response.transaction.list.CustomerInfo;
import com.guardian.reportingapi.dto.response.transaction.list.FxInformation;
import com.guardian.reportingapi.dto.response.transaction.list.Merchant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {
    public TransactionResponse processRequest(TransactionRequest transactionRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // FX Information
        FxInformation fxInformation = FxInformation.builder()
                .merchant(FxInformation.Merchant.builder()
                        .originalAmount(100)
                        .originalCurrency("EUR")
                        .build())
                .build();

        // Customer Information
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

        // Merchant Information
        Merchant merchant = Merchant.builder()
                .name("Dev-Merchant")
                .build();

        // Merchant Transaction Information
        MerchantTransactionInfo.Merchant transaction = MerchantTransactionInfo.Merchant.builder()
                .merchantId(1L)
                .referenceNo("reference_5617ae66281ee")
                .status(Status.WAITING)
                .channel("API")
                .chainId("5617ae666b4cb")
                .agentInfoId(1L)
                .operation("DIRECT")
                .createdAt(LocalDateTime.parse("2015-10-09 12:09:10", formatter))
                .updatedAt(LocalDateTime.parse("2015-10-09 12:09:12", formatter))
                .id(1L)
                .acquirerTransactionId(1L)
                .code("00")
                .message("Waiting")
                .transactionId("1-1444392550-1")
                .agent(MerchantTransactionInfo.Agent.builder()
                        .id(1L)
                        .customerIp("192.168.1.2")
                        .customerUserAgent("Agent")
                        .merchantIp("127.0.0.1")
                        .build())
                .build();

        // Building the final Transaction Response
        return TransactionResponse.builder()
                .fx(fxInformation)
                .customerInfo(customerInfo)
                .merchant(merchant)
                .transaction(MerchantTransactionInfo.builder().merchant(transaction).build())
                .build();
    }
}
