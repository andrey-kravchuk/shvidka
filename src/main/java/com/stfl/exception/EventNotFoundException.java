package com.stfl.exception;

/**
 * This exception throws when event was not found in DB
 */
public class EventNotFoundException extends ApplicationException {

    private static String msg = "event was not found";

    public EventNotFoundException() {
        super(msg);
    }

    public EventNotFoundException(String message) {
        super(msg + "; " + message);
    }
}
