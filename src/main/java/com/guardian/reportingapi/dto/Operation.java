package com.guardian.reportingapi.dto;

import lombok.*;

@Getter
public class Operation {

    public static final String DIRECT = "DIRECT";
    public static final String REFUND = "REFUND";
    public static final String _3D = "3D";
    public static final String _3DAUTH = "3DAUTH";
    public static final String STORED = "STORED";
}
