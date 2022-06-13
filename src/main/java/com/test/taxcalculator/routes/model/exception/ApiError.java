package com.test.taxcalculator.routes.model.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ApiError {
    private final ApiErrorCode errorCode;
    private final String technicalMessage;

    public ApiError(String technicalMessage, ApiErrorCode errorCode) {
        this.technicalMessage = technicalMessage;
        this.errorCode = errorCode;
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }

    public ApiErrorCode getErrorCode() {
        return errorCode;
    }
}
