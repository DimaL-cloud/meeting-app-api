package com.test.meetingapp.exceptions.handlers;

import com.test.meetingapp.exceptions.UnexistingRoomException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {UnexistingRoomException.class})
    public ErrorResponse handleUnknownIdException(UnexistingRoomException e) {
        return new ErrorResponseImpl(e.getErrorCode(), e.getMessage());
    }
}