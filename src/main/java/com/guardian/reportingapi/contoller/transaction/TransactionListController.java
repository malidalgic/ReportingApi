package com.guardian.reportingapi.contoller.transaction;

import com.guardian.reportingapi.dto.request.transaction.list.TransactionListRequest;
import com.guardian.reportingapi.dto.response.transaction.list.TransactionListResponse;
import com.guardian.reportingapi.security.jwt.JwtTokenProvider;
import com.guardian.reportingapi.service.transaction.TransactionListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class TransactionListController {

    private final JwtTokenProvider jwtTokenProvider;
    private final TransactionListService transactionListService;

    @PostMapping("/transaction/list")
    public ResponseEntity<TransactionListResponse> transactionList(
            @RequestHeader("Authorization") String jwtToken,
            @RequestBody TransactionListRequest transactionListRequest) {

        jwtTokenProvider.validateToken(jwtToken);
        TransactionListResponse response = transactionListService.fetchTransactionList(transactionListRequest);

        return ResponseEntity.ok(response);
    }
}
