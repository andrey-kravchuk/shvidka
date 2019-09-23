package com.stfl.exception;

/**
 * This exception throws when user profile was not found in DB
 */
public class UserProfileNotFoundException extends ApplicationException {

    private static String msg = "user profile was not found";

    public UserProfileNotFoundException() {
        super(msg);
    }

    public UserProfileNotFoundException(String message) {
        super(msg + "; " + message);
    }
}
