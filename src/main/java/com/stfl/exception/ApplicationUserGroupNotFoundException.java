package com.stfl.exception;

/**
 * @author Severyn Zlochovksy
 * created at 16.03.2019
 */

public class ApplicationUserGroupNotFoundException extends ApplicationException {

    private static String msg = "User Group was not found";

    public ApplicationUserGroupNotFoundException() {
        super(msg);
    }

    public ApplicationUserGroupNotFoundException(String message) {
        super(msg + "; " + message);
    }
}
