package com.guardian.reportingapi.dto.response.transaction.list;

import com.guardian.reportingapi.dto.enumeration.PaymentMethod;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AcquirerInfo {

    private int id;
    private String name;
    private String code;
    private PaymentMethod type;
}
