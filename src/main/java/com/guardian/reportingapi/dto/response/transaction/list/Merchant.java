package com.guardian.reportingapi.dto.response.transaction.list;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Merchant {
    private int id;
    private String name;
}

