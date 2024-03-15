package com.guardian.reportingapi.contoller.client;

import com.guardian.reportingapi.dto.request.client.ClientRequest;
import com.guardian.reportingapi.dto.response.client.ClientResponse;
import com.guardian.reportingapi.security.jwt.JwtTokenService;
import com.guardian.reportingapi.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class ClientController {

    private final JwtTokenService jwtTokenService;
    private final ClientService clientService;

    @PostMapping("/client")
    public ResponseEntity<ClientResponse> client(
            @RequestHeader("Authorization") String jwtToken,
            @RequestBody @Valid ClientRequest clientRequest) {

        try {
            if (!jwtTokenService.isTokenValid(jwtToken)) {
                log.warn("Unauthorized access attempt with invalid or expired token");

                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            ClientResponse clientResponse = clientService.processRequest(clientRequest);

            return ResponseEntity.ok(clientResponse);
        } catch (Exception e) {
            log.error("Error during transaction processing", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
