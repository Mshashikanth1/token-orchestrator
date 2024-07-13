package com.edralabs.tokenOrchestrator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpServerErrorException;

public class TokenOrchestationServiceException extends HttpServerErrorException {
    public TokenOrchestationServiceException(HttpStatus httpStatus,String message){
        super(httpStatus,message);
    }


}
