package com.dedup.exception;

public class DuplicateUserException extends RuntimeException {
    public  DuplicateUserException(boolean flag) {

        super(String.valueOf(flag));
    }
}
