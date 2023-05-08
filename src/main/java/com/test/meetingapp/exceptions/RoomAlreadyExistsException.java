package com.test.meetingapp.exceptions;

import lombok.Getter;

@Getter
public class RoomAlreadyExistsException extends RuntimeException {
    private final String errorCode = "409";

    public RoomAlreadyExistsException(String identifier) {
        super("Room already exists with identifier " + identifier);
    }
}
