package com.test.meetingapp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class UnexistingRoomException extends RuntimeException {
    private final HttpStatusCode errorCode = HttpStatus.NOT_FOUND;

    public UnexistingRoomException(String identifier) {
        super("Unexisting room with identifier " + identifier);
    }
}
