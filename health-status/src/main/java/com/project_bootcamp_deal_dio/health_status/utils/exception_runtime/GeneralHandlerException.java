package com.project_bootcamp_deal_dio.health_status.utils.exception_runtime;

import com.project_bootcamp_deal_dio.health_status.utils.models.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralHandlerException
{

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException e){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.of(e.returnStatusCode(), e.getMessage());
        return ResponseEntity.status(e.returnStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException e){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.of(e.returnStatusCode(), e.getMessage());
        return ResponseEntity.status(e.returnStatusCode()).body(apiResponse);
    }

}