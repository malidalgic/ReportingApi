package com.guardian.reportingapi.service.transaction;

import com.guardian.reportingapi.dto.enumeration.Status;
import com.guardian.reportingapi.dto.request.transaction.report.TransactionReportRequest;
import com.guardian.reportingapi.dto.response.transaction.report.Response;
import com.guardian.reportingapi.dto.response.transaction.report.TransactionReportResponse;
import com.guardian.reportingapi.exception.ReportNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TransactionReportService {

    public TransactionReportResponse fetchTransactionReport(TransactionReportRequest transactionReportRequest) {
        List<Response> response = generateResponse(transactionReportRequest);

        if (response == null) {
            throw new ReportNotFoundException();
        }

        return TransactionReportResponse.builder()
                .status(Status.APPROVED)
                .response(response)
                .build();

    }

    private List<Response> generateResponse(TransactionReportRequest transactionReportRequest) {

        return Stream.of(Response.builder().count(283).total(28300).currency("USD").build(),
                        Response.builder().count(280).total(1636515).currency("EUR").build())
                .collect(Collectors.toList());
    }
}
