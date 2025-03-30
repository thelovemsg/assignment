package com.example.assignment.common.exception;

import com.example.assignment.common.message.MessageCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(MessageCode code, Object... args) {
        super(code.format(args));
    }
}