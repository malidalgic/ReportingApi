package com.guardian.reportingapi.dto.response.transaction.list;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FxInformation {

    private Merchant merchant;

    @Getter
    @Builder
    public static class Merchant {

        private int originalAmount;
        private String originalCurrency;
    }
}
