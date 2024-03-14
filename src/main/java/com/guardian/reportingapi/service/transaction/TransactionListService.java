package com.guardian.reportingapi.service.transaction;

import com.guardian.reportingapi.dto.Operation;
import com.guardian.reportingapi.dto.enumeration.PaymentMethod;
import com.guardian.reportingapi.dto.enumeration.Status;
import com.guardian.reportingapi.dto.request.transaction.TransactionListRequest;
import com.guardian.reportingapi.dto.response.transaction.list.*;
import com.guardian.reportingapi.exception.ListNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionListService {

    public TransactionListResponse fetchTransactionList(TransactionListRequest transactionListRequest) {

        TransactionListResponse response = generateResponse(transactionListRequest);

        if (response == null) {
            log.error("List not found or response is null");
            throw new ListNotFoundException("List not found or response is null");
        }

        return response;
    }

    private TransactionListResponse generateResponse(TransactionListRequest transactionListRequest) {

        int perPage = 50;
        int currentPage = transactionListRequest.getPage();

        List<Data> dataList = generateDataList();

        return TransactionListResponse.builder()
                .per_page(perPage)
                .current_page(currentPage)
                .next_page_url("http://example.com/api/page=" + (currentPage + 1))
                .prev_page_url(currentPage > 1 ? "http://example.com/api/page=" + (currentPage - 1) : null)
                .from(1)
                .to(perPage)
                .data(dataList)
                .build();
    }

    private List<Data> generateDataList() {
        return Stream.of(createDataObject()).collect(Collectors.toList());
    }

    private Data createDataObject() {
        return Data.builder()
                .fx(FxInformation.builder()
                        .merchant(FxInformation.Merchant.builder()
                                .originalAmount(5)
                                .originalCurrency("EUR")
                                .build())
                        .build())
                .customerInfo(CustomerInfo.builder()
                        .number("448574XXXXXX3395")
                        .email("aykut.aras@bumin.com.tr")
                        .billingFirstName("Aykut")
                        .billingLastName("Aras")
                        .build())
                .merchant(Merchant.builder()
                        .id(3)
                        .name("Dev-Merchant")
                        .build())
                .ipn(IpnReceived.builder()
                        .received(true)
                        .build())
                .transaction(TransactionInfo.builder()
                        .merchant(TransactionInfo.Merchant.builder()
                                .referenceNo("api_560a4a9314208")
                                .status(Status.APPROVED)
                                .operation(Operation._3DAUTH)
                                .message("Auth3D is" + Status.APPROVED)
                                .created_at(generateLocalDateTime())
                                .transactionId("2827-1443515082-3")
                                .build())
                        .build())
                .acquirer(AcquirerInfo.builder()
                        .id(12)
                        .name("Mergen Bank")
                        .code("MB")
                        .type(PaymentMethod.CREDITCARD)
                        .build())
                .refundable(true)
                .build();
    }

    private LocalDateTime generateLocalDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse("2015-09-29 08:24:42", formatter);
    }
}
