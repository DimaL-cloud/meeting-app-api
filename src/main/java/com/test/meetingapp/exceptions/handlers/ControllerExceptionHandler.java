package com.test.meetingapp.exceptions.handlers;

import com.test.meetingapp.exceptions.RoomAlreadyExistsException;
import com.test.meetingapp.exceptions.UnexistingRoomException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(value = {UnexistingRoomException.class})
    public ErrorResponse handleUnexistingRoomException(UnexistingRoomException e) {
        return new ErrorResponseImpl(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(value = {RoomAlreadyExistsException.class})
    public ErrorResponse handleRoomAlreadyExistsException(RoomAlreadyExistsException e) {
        return new ErrorResponseImpl(e.getErrorCode(), e.getMessage());
    }
}