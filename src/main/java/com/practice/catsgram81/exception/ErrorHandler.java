package com.practice.catsgram81.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerUserNotFoundException(UserNotFoundException ex){
        return new ErrorResponse("Пользователь не найден", ex.getMessage());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerPostNotFoundException(PostNotFoundException ex){
        return new ErrorResponse("Пост не найден", ex.getMessage());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerUserAlreadyExistException(UserAlreadyExistException ex){
        return new ErrorResponse("Пользователь существует", ex.getMessage());
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerInvalidEmailException(InvalidEmailException ex){
        return new ErrorResponse("почту не водили", ex.getMessage());
    }
}
