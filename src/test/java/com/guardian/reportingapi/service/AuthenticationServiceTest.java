package com.guardian.reportingapi.service;

import com.guardian.reportingapi.entity.User;
import com.guardian.reportingapi.repository.UserRepository;
import com.guardian.reportingapi.security.jwt.JwtTokenProvider;
import com.guardian.reportingapi.service.auth.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private AuthenticationService authenticationService;

    private static final String EMAIL = "merchant@test.com";
    private static final String PASSWORD = "12345";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private void setupUserRepository(boolean userExists) {
        Optional<User> userOptional = userExists ? Optional.of(User.builder()
                .id(1L)
                .email(EMAIL)
                .firstName("Test")
                .lastName("Test")
                .password(PASSWORD)
                .build()) : Optional.empty();
        when(userRepository.findUserByEmailAndPassword(EMAIL, PASSWORD)).thenReturn(userOptional);
    }

    @Test
    void validateUser_WhenUserExists_ShouldReturnTrue() {
        setupUserRepository(true);

        boolean result = authenticationService.validateUser(EMAIL, PASSWORD);

        assertTrue(result);
    }

    @Test
    void validateUser_WhenUserDoesNotExist_ShouldReturnFalse() {
        setupUserRepository(false);

        boolean result = authenticationService.validateUser(EMAIL, PASSWORD);

        assertFalse(result);
    }

    @Test
    void createToken_ShouldReturnToken() {
        String expectedToken = "u4QFGwEK8cEGMNmeYLjgWse9Nqg4ip_UeNGwf6RiHU8token123u4QFGwEK8cEGMNmeYLjgWse9Nqg4ip_UeNGwf6RiHU8";
        when(jwtTokenProvider.createToken(EMAIL)).thenReturn(expectedToken);

        String token = authenticationService.createToken(EMAIL);

        assertEquals(expectedToken, token);
    }
}