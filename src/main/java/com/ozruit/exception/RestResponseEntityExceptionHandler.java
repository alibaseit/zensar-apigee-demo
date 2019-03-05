package com.ozruit.exception;

import com.ozruit.model.ProductResponse;
import com.ozruit.model.ResponseStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RestClientException.class)
    public final ResponseEntity<ProductResponse> handleApigeeExceptions(RestClientException ex, WebRequest request) {
        ProductResponse response = new ProductResponse();
        response.setStatus(new ResponseStatus("APIGEE_ERROR", ex.getMessage()));
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ProductResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ProductResponse response = new ProductResponse();
        response.setStatus(new ResponseStatus("ERROR", ex.getMessage()));
        return ResponseEntity.badRequest().body(response);
    }

}