package com.guardian.reportingapi.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.guardian.reportingapi.dto.enumeration.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
    private Status status;
}
