package com.guardian.reportingapi.contoller.client;

import com.guardian.reportingapi.dto.request.client.ClientRequest;
import com.guardian.reportingapi.dto.response.client.ClientResponse;
import com.guardian.reportingapi.security.jwt.JwtTokenProvider;
import com.guardian.reportingapi.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class ClientController {

    private final JwtTokenProvider jwtTokenProvider;
    private final ClientService clientService;

    @PostMapping("/client")
    public ResponseEntity<ClientResponse> client(
            @RequestHeader("Authorization") String jwtToken,
            @RequestBody @Valid ClientRequest clientRequest) {

        jwtTokenProvider.validateToken(jwtToken);
        ClientResponse clientResponse = clientService.processRequest(clientRequest);

        return ResponseEntity.ok(clientResponse);
    }
}
