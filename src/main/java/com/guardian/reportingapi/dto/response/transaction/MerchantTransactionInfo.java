package com.guardian.reportingapi.dto.response.transaction;

import lombok.Builder;
import lombok.Getter;
import org.aspectj.weaver.loadtime.Agent;

import java.time.LocalDateTime;

@Getter
@Builder
public class MerchantTransactionInfo {

    private String referenceNo;
    private Integer merchantId;
    private String status;
    private String channel;
    private String customData;
    private String chainId;
    private Integer agentInfoId;
    private String operation;
    private Integer fxTransactionId;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private Integer id;
    private Integer acquirerTransactionId;
    private String code;
    private String message;
    private String transactionId;
    private Agent agent;
}
