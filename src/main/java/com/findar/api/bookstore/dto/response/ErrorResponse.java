package com.findar.api.bookstore.dto.response;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {
    private int errorCode;
    private HttpStatus httpStatus;
    private String message;
    private Map<String, String> errorFields;

    public ErrorResponse() {
        this.errorFields = new HashMap<>();
    }

    public ErrorResponse(int errorCode, HttpStatus httpStatus, String message) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.message = message;
        this.errorFields = new HashMap<>();
    }

    public Map<String, String> getErrorFields() {
        return errorFields;
    }

    public void setErrorFields(Map<String, String> errorFields) {
        this.errorFields = errorFields;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
