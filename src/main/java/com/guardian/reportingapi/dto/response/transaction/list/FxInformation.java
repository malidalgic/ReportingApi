package com.guardian.reportingapi.dto.response.transaction.list;

import lombok.Builder;

@Builder
public class FxInformation {
    private Merchant merchant;

    @Builder
    public static class Merchant {
        private int originalAmount;
        private String originalCurrency;
    }
}
