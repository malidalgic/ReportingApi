package com.guardian.reportingapi.service.auth;

import com.guardian.reportingapi.entity.User;
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

    public boolean validateUser(String email, String password) {
        Optional<User> user = userRepository.findUserByEmailAndPassword(email, password);
        return user.isPresent();
    }

    public String createToken(String email) {
        return jwtTokenProvider.createToken(email);
    }
}
