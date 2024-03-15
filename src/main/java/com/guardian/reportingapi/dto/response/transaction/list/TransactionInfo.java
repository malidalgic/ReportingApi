package com.guardian.reportingapi.dto.response.transaction.list;

import com.guardian.reportingapi.dto.enumeration.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TransactionInfo {
    private Merchant merchant;

    @Getter
    @Builder
    public static class Merchant {

        private String referenceNo;
        private Status status;
        private String operation;
        private String message;
        private LocalDateTime created_at;
        private String transactionId;
    }
}
