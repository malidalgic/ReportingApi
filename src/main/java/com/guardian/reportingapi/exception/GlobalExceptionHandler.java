package com.guardian.reportingapi.exception;

import com.guardian.reportingapi.dto.enumeration.Status;
import com.guardian.reportingapi.dto.response.InvalidTokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errors = ex.getBindingResult().getAllErrors().stream()
                .collect(Collectors.groupingBy(
                        error -> ((FieldError) error).getField(),
                        Collectors.mapping(ObjectError::getDefaultMessage, Collectors.toList())
                ));

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<Object> handleInvalidTokenException(InvalidTokenException e) {
        log.warn("Unauthorized access attempt with invalid or expired token: " + e.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(InvalidTokenResponse.builder()
                .status(Status.DECLINED)
                .message(e.getMessage())
                .build());
    }

    @ExceptionHandler(ReportNotFoundException.class)
    public ResponseEntity<Object> handleReportNotFoundException() {
        log.warn("Report not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Report not found");
    }

    @ExceptionHandler(ListNotFoundException.class)
    public ResponseEntity<Object> handleListNotFoundException() {
        log.warn("List not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List not found");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException() {
        log.warn("User not Found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
