package com.guardian.reportingapi.dto.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class LoginRequest {

    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
