package com.test.meetingapp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class WrongRoomParamException extends RuntimeException {
    private final HttpStatusCode code = HttpStatus.UNAUTHORIZED;

    public WrongRoomParamException(String message) {
        super(message);
    }
}
