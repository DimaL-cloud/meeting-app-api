package com.test.meetingapp.exceptions;

import lombok.Getter;

@Getter
public class UnexistingRoomException extends RuntimeException {
    private final String errorCode = "404";

    public UnexistingRoomException(String identifier) {
        super("Unexisting room with identifier " + identifier);
    }
}
