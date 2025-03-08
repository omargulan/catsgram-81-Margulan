package com.practice.catsgram81.exception;

public class UserAlreadyExistException  extends RuntimeException{
    public UserAlreadyExistException(String message) {
        super(message);
    }

}
