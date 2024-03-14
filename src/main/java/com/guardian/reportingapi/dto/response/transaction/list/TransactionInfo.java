package com.guardian.reportingapi.dto.response.transaction.list;

import com.guardian.reportingapi.dto.enumeration.Status;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class TransactionInfo {
    private Merchant merchant;

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
