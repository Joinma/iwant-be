package com.liori.common.exceptions;

import org.springframework.http.HttpStatus;

public class CustomizeServiceException extends RuntimeException {

    private HttpStatus status;

    public CustomizeServiceException(String message) {
        super(message);
    }

    public CustomizeServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomizeServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
