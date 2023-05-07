package com.test.meetingapp.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class WrongRoomParamException extends RuntimeException {
    private final HttpStatusCode code = HttpStatusCode.valueOf(401);

    public WrongRoomParamException(String message) {
        super(message);
    }
}
