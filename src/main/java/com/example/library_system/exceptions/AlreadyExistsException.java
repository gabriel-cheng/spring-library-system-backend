package com.example.library_system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends Exception {

    public AlreadyExistsException(String message) {
        super(message);
    }

}
