package com.guardian.reportingapi.contoller.transaction;

import com.guardian.reportingapi.dto.request.transaction.TransactionListRequest;
import com.guardian.reportingapi.dto.response.transaction.list.TransactionListResponse;
import com.guardian.reportingapi.exception.ListNotFoundException;
import com.guardian.reportingapi.security.jwt.JwtTokenService;
import com.guardian.reportingapi.service.transaction.TransactionListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class TransactionListController {

    private final JwtTokenService jwtTokenService;
    private final TransactionListService transactionListService;

    @PostMapping("/transaction/list")
    public ResponseEntity<TransactionListResponse> transactionList(
            @RequestHeader("Authorization") String jwtToken,
            @RequestBody TransactionListRequest transactionListRequest) {

        try {
            if (!jwtTokenService.isTokenValid(jwtToken)) {
                log.warn("Unauthorized access attempt with invalid or expired token");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            TransactionListResponse response = transactionListService.fetchTransactionList(transactionListRequest);
            return ResponseEntity.ok(response);
        } catch (ListNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            log.error("Error occurred during transaction list processing: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
