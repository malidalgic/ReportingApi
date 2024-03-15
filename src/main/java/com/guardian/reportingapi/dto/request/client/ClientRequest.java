package com.guardian.reportingapi.dto.request.client;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    @NotNull
    @NotBlank
    private String transactionId;
}