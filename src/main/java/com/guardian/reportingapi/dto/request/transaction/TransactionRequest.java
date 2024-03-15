package com.guardian.reportingapi.dto.request.transaction;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    @NotNull
    @NotBlank
    private String transactionId;
}
