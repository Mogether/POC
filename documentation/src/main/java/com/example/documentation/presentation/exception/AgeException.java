package com.example.documentation.presentation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AgeException extends RuntimeException {

    public AgeException() {
        super("에러입니다.");
    }
}
