package com.ashupan.appuserservice.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author 
 */
@Getter
@Setter
public class DataDuplicationException extends RuntimeException {
    private ErrorResponse errorResponse;

    public DataDuplicationException(String message, String developerMessage) {
        super(message);
        errorResponse = new ErrorResponse(message, developerMessage, HttpStatus.CONFLICT, HttpStatus.CONFLICT.value());
    }
    
    
}
