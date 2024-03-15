package com.guardian.reportingapi.dto.response.transaction;

import com.guardian.reportingapi.dto.enumeration.Status;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class MerchantTransactionInfo {

    private Merchant merchant;

    @Getter
    @Builder
    public static class Merchant {

        private String referenceNo;
        private Long merchantId;
        private Status status;
        private String channel;
        private String customData;
        private String chainId;
        private Long agentInfoId;
        private String operation;
        private Long fxTransactionId;
        private LocalDateTime updatedAt;
        private LocalDateTime createdAt;
        private Long id;
        private Long acquirerTransactionId;
        private String code;
        private String message;
        private String transactionId;
        private Agent agent;
    }

    @Getter
    @Builder
    public static class Agent {

        private Long id;
        private String customerIp;
        private String customerUserAgent;
        private String merchantIp;
    }
}
