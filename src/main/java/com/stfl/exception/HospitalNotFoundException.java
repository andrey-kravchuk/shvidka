package com.stfl.exception;

public class HospitalNotFoundException extends ApplicationException {

    private static String msg = "hospital was not found";

    public HospitalNotFoundException() {
        super(msg);
    }

    public HospitalNotFoundException(String message) {
        super(msg + ";" + message);
    }
}
