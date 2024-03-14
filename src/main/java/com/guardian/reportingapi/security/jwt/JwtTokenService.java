package com.guardian.reportingapi.security.jwt;

import com.guardian.reportingapi.exception.InvalidTokenException;
import com.guardian.reportingapi.exception.ReportNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenService {

    private final JwtTokenProvider jwtTokenProvider;

    public boolean isTokenValid(String token) {
        try {
            return jwtTokenProvider.validateToken(token);
        } catch (InvalidTokenException e) {
            log.error("Token validation error: ", e);
            return false;
        }
    }
}
