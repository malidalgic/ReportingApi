package com.guardian.reportingapi.dto.request;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@Builder
public class LoginRequest {

    @NotNull
    private String email;
    @NotNull
    private String password;
}
