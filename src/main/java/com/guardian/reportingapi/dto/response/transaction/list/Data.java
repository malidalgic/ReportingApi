package com.guardian.reportingapi.dto.response.transaction.list;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Data {

    private FxInformation fx;
    private CustomerInfo customerInfo;
    private Merchant merchant;
    private IpnReceived ipn;
    private TransactionInfo transaction;
    private AcquirerInfo acquirer;
    private boolean refundable;
}

