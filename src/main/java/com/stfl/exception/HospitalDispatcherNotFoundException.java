package com.stfl.exception;

public class HospitalDispatcherNotFoundException extends ApplicationException {

    private static String msg = "hospital dispatcher was not found";

    public HospitalDispatcherNotFoundException() {
        super(msg);
    }

    public HospitalDispatcherNotFoundException(String message) {
        super(msg + "; " + message);
    }
}
