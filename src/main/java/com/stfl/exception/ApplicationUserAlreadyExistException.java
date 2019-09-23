package com.stfl.exception;

/**
 * This exception throws when user is already exist in DB
 */
public class ApplicationUserAlreadyExistException extends ApplicationException {

    private static String msg = "user is already exist";


    public ApplicationUserAlreadyExistException() {
        super(msg);
    }

    public ApplicationUserAlreadyExistException(String message) {
        super(msg + "; " + message);
    }
}