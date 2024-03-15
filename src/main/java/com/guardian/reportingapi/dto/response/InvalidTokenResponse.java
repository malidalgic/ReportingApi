package com.guardian.reportingapi.dto.response;

import com.guardian.reportingapi.dto.enumeration.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InvalidTokenResponse {

    private Status status;
    private String message;
}
