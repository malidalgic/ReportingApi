package com.guardian.reportingapi.contoller.transaction;

import com.guardian.reportingapi.dto.request.transaction.report.TransactionReportRequest;
import com.guardian.reportingapi.dto.response.transaction.report.TransactionReportResponse;
import com.guardian.reportingapi.security.jwt.JwtTokenProvider;
import com.guardian.reportingapi.service.transaction.TransactionReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class TransactionReportController {

    private final TransactionReportService transactionReportService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/transaction/report")
    public ResponseEntity<TransactionReportResponse> transactionReport(
            @RequestHeader("Authorization") String jwtToken,
            @RequestBody @Valid TransactionReportRequest transactionReportRequest) {

        jwtTokenProvider.validateToken(jwtToken);
        TransactionReportResponse response = transactionReportService.fetchTransactionReport(transactionReportRequest);

        return ResponseEntity.ok(response);
    }
}
