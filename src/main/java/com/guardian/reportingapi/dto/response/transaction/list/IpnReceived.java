package com.guardian.reportingapi.dto.response.transaction.list;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IpnReceived {

    private boolean received;
}
