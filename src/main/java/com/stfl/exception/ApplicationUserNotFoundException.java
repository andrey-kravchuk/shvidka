package com.stfl.exception;

/**
 * This exception throws when user was not found in DB
 */
public class ApplicationUserNotFoundException extends ApplicationException {

    private static String msg = "user was not found";


    public ApplicationUserNotFoundException() {
        super(msg);
    }

    public ApplicationUserNotFoundException(String message) {
        super(msg + "; " + message);
    }
}
