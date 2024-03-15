package com.guardian.reportingapi.contoller.transaction;

import com.guardian.reportingapi.dto.request.transaction.TransactionRequest;
import com.guardian.reportingapi.dto.response.transaction.TransactionResponse;
import com.guardian.reportingapi.security.jwt.JwtTokenService;
import com.guardian.reportingapi.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class TransactionController {

    private final JwtTokenService jwtTokenService;
    private final TransactionService transactionService;

    @GetMapping("/transaction")
    public ResponseEntity<TransactionResponse> fetchTransaction(
            @RequestHeader("Authorization") String jwtToken,
            @RequestBody TransactionRequest transactionRequest) {

        try {
            if (!jwtTokenService.isTokenValid(jwtToken)) {
                log.warn("Unauthorized access attempt with invalid or expired token");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            TransactionResponse transactionResponse = transactionService.processRequest(transactionRequest);

            return ResponseEntity.ok(transactionResponse);
        } catch (Exception e) {
            log.error("Error during transaction processing", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
