package com.guardian.reportingapi.service.auth;

import com.guardian.reportingapi.domain.User;
import com.guardian.reportingapi.dto.request.LoginRequest;
import com.guardian.reportingapi.exception.UserNotFoundException;
import com.guardian.reportingapi.repository.UserRepository;
import com.guardian.reportingapi.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public void validateUser(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findUserByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        user.orElseThrow(UserNotFoundException::new);
    }

    public String createToken(String email) {
        return jwtTokenProvider.createToken(email);
    }
}
