package com.project_bootcamp_deal_dio.health_status.utils.exception_runtime;

public class Exceptions extends java.lang.Exception {

    public Exceptions (String message, Object o, boolean b, boolean b1){
        super(message, null, false, false);
    }

    public Exceptions (String message, Throwable cause){
        super(message, cause, false, false);
    }

}