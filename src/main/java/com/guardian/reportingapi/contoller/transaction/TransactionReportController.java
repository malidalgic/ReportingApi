package com.guardian.reportingapi.contoller.transaction;

import com.guardian.reportingapi.dto.enumeration.Status;
import com.guardian.reportingapi.dto.request.transaction.report.TransactionReportRequest;
import com.guardian.reportingapi.dto.response.transaction.report.TransactionReportResponse;
import com.guardian.reportingapi.exception.ReportNotFoundException;
import com.guardian.reportingapi.security.jwt.JwtTokenService;
import com.guardian.reportingapi.service.transaction.TransactionReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class TransactionReportController {

    private final TransactionReportService transactionReportService;
    private final JwtTokenService jwtTokenService;

    @PostMapping("/transaction/report")
    public ResponseEntity<TransactionReportResponse> transactionReport(
            @RequestHeader("Authorization") String jwtToken,
            @RequestBody @Validated TransactionReportRequest transactionReportRequest) {

        try {
            if (!jwtTokenService.isTokenValid(jwtToken)) {
                log.warn("Unauthorized access attempt with invalid or expired token");

                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(TransactionReportResponse.builder()
                        .status(Status.DECLINED)
                        .build());
            }

            TransactionReportResponse response = transactionReportService.fetchTransactionReport(transactionReportRequest);

            return ResponseEntity.ok(response);
        } catch (ReportNotFoundException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(TransactionReportResponse.builder()
                    .status(Status.DECLINED)
                    .build());
        } catch (Exception e) {
            log.error("Error occurred while fetching transaction report: ");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(TransactionReportResponse.builder()
                    .status(Status.ERROR)
                    .build());
        }
    }
}
