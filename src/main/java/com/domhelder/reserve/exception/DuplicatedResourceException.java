package com.domhelder.reserve.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicatedResourceException extends RuntimeException {
    public DuplicatedResourceException(String message) {
        super(message);
    }
}
