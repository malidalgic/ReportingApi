package com.guardian.reportingapi.contoller.transaction;

import com.guardian.reportingapi.dto.request.transaction.TransactionRequest;
import com.guardian.reportingapi.dto.response.transaction.TransactionResponse;
import com.guardian.reportingapi.security.jwt.JwtTokenProvider;
import com.guardian.reportingapi.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/")
public class TransactionController {

    private final JwtTokenProvider jwtTokenProvider;
    private final TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<TransactionResponse> transaction(
            @RequestHeader("Authorization") String jwtToken,
            @RequestBody @Valid TransactionRequest transactionRequest) {

        jwtTokenProvider.validateToken(jwtToken);
        TransactionResponse transactionResponse = transactionService.processRequest(transactionRequest);

        return ResponseEntity.ok(transactionResponse);
    }
}
