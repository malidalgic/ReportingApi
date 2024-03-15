package com.guardian.reportingapi.dto.response.transaction;

import com.guardian.reportingapi.dto.response.transaction.list.CustomerInfo;
import com.guardian.reportingapi.dto.response.transaction.list.FxInformation;
import com.guardian.reportingapi.dto.response.transaction.list.Merchant;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TransactionResponse {

    private FxInformation fx;
    private CustomerInfo customerInfo;
    private AcquirerTransactionInfo acquirerTransactions;
    private Merchant merchant;
    private MerchantTransactionInfo merchantTransactions;
}
