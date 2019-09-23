package com.stfl.exception;

public class AddressNotFoundException extends ApplicationException {
    private static final String msg = "Address not found";

    public AddressNotFoundException() {
        super(msg);
    }

    public AddressNotFoundException(String message) {
        super(msg + "; " + message);
    }
}
