package com.rest.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ContactNotFoundException extends ResponseStatusException {
    public ContactNotFoundException(String message, Throwable t) {
        super(HttpStatus.NOT_FOUND, message, t);
    }
}
