package com.guardian.reportingapi.dto.response.client;

import com.guardian.reportingapi.dto.response.transaction.list.CustomerInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientResponse {

    private CustomerInfo customerInfo;
}
