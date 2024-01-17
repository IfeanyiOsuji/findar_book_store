package com.findar.api.bookstore.errohandling;

import com.findar.api.bookstore.dto.response.ErrorResponse;
import com.findar.api.bookstore.exceptions.BookAlreadyExistException;
import com.findar.api.bookstore.exceptions.BookNotFoundException;
import com.findar.api.bookstore.exceptions.NoAvailableBookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ExceptionHandler {
    /*
     * This class handles the error and sends the response to the client
     * */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, ErrorResponse> handleInvalidArguments(MethodArgumentNotValidException ex){
        Map<String, ErrorResponse>errorResponse = new HashMap<>();
        Map<String, String>errorMessage = new HashMap<>();
        ErrorResponse errorResponse1 = new ErrorResponse(ex.getStatusCode().value(), HttpStatus.BAD_REQUEST, "Validation failed");
        ex.getBindingResult().getFieldErrors().forEach(error->{
            errorMessage.put(error.getField(), error.getDefaultMessage());
        });
        errorResponse1.setErrorFields(errorMessage);
        errorResponse.put("error", errorResponse1);
        return errorResponse;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(BookNotFoundException.class)

    public Map<String, ErrorResponse> handleBusinessException(BookNotFoundException ex){
        Map<String, ErrorResponse>errorMessage = new HashMap<>();
        errorMessage.put("error", new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
        return errorMessage;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(BookAlreadyExistException.class)
    public Map<String, ErrorResponse> handleBookNotFoundException(BookAlreadyExistException ex){
        Map<String, ErrorResponse>errorMessage = new HashMap<>();
        errorMessage.put("error", new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
        return errorMessage;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(NoAvailableBookException.class)
    public Map<String, ErrorResponse> handleBookNotFoundException(NoAvailableBookException ex){
        Map<String, ErrorResponse>errorMessage = new HashMap<>();
        errorMessage.put("error", new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
        return errorMessage;
    }
}
