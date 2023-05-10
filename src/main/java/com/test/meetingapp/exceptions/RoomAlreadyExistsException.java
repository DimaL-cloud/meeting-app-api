package com.test.meetingapp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class RoomAlreadyExistsException extends RuntimeException {
    private final HttpStatusCode errorCode = HttpStatus.CONFLICT;

    public RoomAlreadyExistsException(String identifier) {
        super("Room already exists with identifier " + identifier);
    }
}
