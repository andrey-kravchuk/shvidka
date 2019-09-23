package com.stfl.exception;

/**
 * This exception throws when it is saving incorrect user
 */
public class ApplicationUserNotSpecifiedException extends ApplicationException {
    private static String msg = "user is not specified";

    public ApplicationUserNotSpecifiedException() {
        super(msg);
    }

    public ApplicationUserNotSpecifiedException(String message) {
        super(msg + "; " + message);
    }
}
