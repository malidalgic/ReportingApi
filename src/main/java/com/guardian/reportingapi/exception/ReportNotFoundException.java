package com.guardian.reportingapi.exception;

public class ReportNotFoundException extends RuntimeException {

    public ReportNotFoundException(String message) {
        super(message);
    }
}
