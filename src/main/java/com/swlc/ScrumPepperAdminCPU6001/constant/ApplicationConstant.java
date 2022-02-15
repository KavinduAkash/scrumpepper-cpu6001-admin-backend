package com.swlc.ScrumPepperAdminCPU6001.constant;

/**
 * @author hp
 */
public class ApplicationConstant {
    public static final String API_BASE_URL = "/v1";
    /**
     * Exception error message constants
     */
    //don't use this variable for other error messages (only exception class use)
    public static final String APPLICATION_ERROR_OCCURRED_MESSAGE = "Application Error Occurred";

    public static final int COMMON_ERROR_CODE = 101;
    public static final int RESOURCE_NOT_FOUND = 404;
    public static final int RESOURCE_ALREADY_EXIST = 409;
    public static final int UN_AUTH_ACTION = 491;
    public static final int UNABLE_TO_SEND_EMAIL = 422;
    public static final int UNABLE_UPLOAD_FILE = 421;

}
