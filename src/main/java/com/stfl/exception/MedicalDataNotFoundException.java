package com.stfl.exception;

public class MedicalDataNotFoundException extends ApplicationException {
    private static final String msg = "Medical data not found";

    public MedicalDataNotFoundException(){
        super(msg);
    }
    public MedicalDataNotFoundException(String message) {
        super(msg + "; " + message);
    }
}
