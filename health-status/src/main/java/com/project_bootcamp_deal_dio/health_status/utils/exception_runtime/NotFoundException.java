package com.project_bootcamp_deal_dio.health_status.utils.exception_runtime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public HttpStatus returnStatusCode(){
        return HttpStatus.NOT_FOUND;
    }
}