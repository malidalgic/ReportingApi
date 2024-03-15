package com.guardian.reportingapi.contoller.auth;

import com.guardian.reportingapi.dto.enumeration.Status;
import com.guardian.reportingapi.dto.request.LoginRequest;
import com.guardian.reportingapi.dto.response.LoginResponse;
import com.guardian.reportingapi.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/merchant/user/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated LoginRequest loginRequest) {
        try {
            boolean isValidUser = authenticationService.validateUser(loginRequest.getEmail(), loginRequest.getPassword());

            if (isValidUser) {
                String token = authenticationService.createToken(loginRequest.getEmail());
                return ResponseEntity.status(HttpStatus.OK).body(LoginResponse.builder()
                        .token(token)
                        .status(Status.APPROVED)
                        .build());
            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(LoginResponse.builder()
                                .status(Status.DECLINED)
                                .build());
            }
        } catch (Exception e) {
            log.error("An error occurred during login", e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(LoginResponse.builder()
                            .status(Status.ERROR)
                            .build());
        }
    }
}
