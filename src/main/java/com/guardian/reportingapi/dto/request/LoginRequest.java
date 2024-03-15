package com.guardian.reportingapi.dto.request;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class LoginRequest {

    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;
}
