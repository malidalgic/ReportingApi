package com.guardian.reportingapi.contoller.auth;

import com.guardian.reportingapi.dto.enumeration.Status;
import com.guardian.reportingapi.dto.request.LoginRequest;
import com.guardian.reportingapi.dto.response.LoginResponse;
import com.guardian.reportingapi.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/merchant/user/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {

        authenticationService.validateUser(loginRequest);
        String token = authenticationService.createToken(loginRequest.getEmail());

        return ResponseEntity.status(HttpStatus.OK).body(LoginResponse.builder()
                .token(token)
                .status(Status.APPROVED)
                .build());
    }
}
