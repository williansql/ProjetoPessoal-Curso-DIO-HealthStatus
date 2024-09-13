package com.project_bootcamp_deal_dio.health_status.utils.exception_runtime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestExceptions extends RuntimeException {

    public BadRequestExceptions(String message) {
        super(message, null, false, false);
    }

    public BadRequestExceptions(String message, Throwable cause) {
        super(message, cause, false, false);
    }

    public HttpStatus returnStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}