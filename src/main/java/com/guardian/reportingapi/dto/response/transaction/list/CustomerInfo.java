package com.guardian.reportingapi.dto.response.transaction.list;

import lombok.Builder;

@Builder
public class CustomerInfo {
    private String number;
    private String email;
    private String billingFirstName;
    private String billingLastName;
}
