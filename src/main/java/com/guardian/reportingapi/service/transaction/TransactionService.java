package com.guardian.reportingapi.service.transaction;

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
        MerchantTransactionInfo merchantTransactions = MerchantTransactionInfo.builder()
                .merchantId(1)
                .referenceNo("reference_5617ae66281ee")
                .status("WAITING")
                .operation("DIRECT")
                .createdAt(LocalDateTime.parse("2015-10-09 12:09:10", formatter))
                .updatedAt(LocalDateTime.parse("2015-10-09 12:09:12", formatter))
                .transactionId("1-1444392550-1")
                .build();

        // Building the final Transaction Response
        return TransactionResponse.builder()
                .fx(fxInformation)
                .customerInfo(customerInfo)
                .merchant(merchant)
                .merchantTransactions(merchantTransactions)
                .build();
    }
}
