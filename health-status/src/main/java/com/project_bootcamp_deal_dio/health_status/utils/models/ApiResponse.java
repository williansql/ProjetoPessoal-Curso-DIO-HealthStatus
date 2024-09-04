package com.project_bootcamp_deal_dio.health_status.utils.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private int status = HttpStatus.OK.value();
    private String message = "";
    private String token = "";
    private T data = null;

    public ApiResponse<T> of(HttpStatus httpStatus, String message){
        this.status = httpStatus.value();
        this.message = message;
        return this;
    }

    public ApiResponse<T> of(HttpStatus httpStatus, String message,T data){
        this.status = httpStatus.value();
        this.message = message;
        this.data = data;
        return this;
    }

    public ApiResponse<T> of (HttpStatus httpStatus, String message,T data ,String token){
        this.status = httpStatus.value();
        this.message = message;
        this.data = data;
        this.token = token;
        return this;
    }
}