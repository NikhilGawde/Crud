package com.example.Crud.exceptionHandler;

import com.example.Crud.globalException.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<Object> handleIdNotFound(StudentNotFoundException ex, WebRequest request){

        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
