package com.customer.service.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

@RestControllerAdvice
@Slf4j
public class ErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(f -> String.format("%s%s%s", f.getField(), " ", f.getDefaultMessage()))
                .collect(Collectors.toList());

        ErrorMessage errorMessage = ErrorMessage.builder()
                .errors(errors)
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        return handleExceptionInternal(ex, errorMessage, headers, HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        Object message = "";
        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException exception = (InvalidFormatException) ex.getCause();
            message = exception.getValue();
        }

        ErrorMessage errorMessage = ErrorMessage.builder()
                .errors(singletonList("It's not possible convert value " + message))
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handlerConstraintViolationException(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .errors(errors)
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        log.error("Error handler = {}", ex.getMessage(), ex);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handlerInvalidDocumentException(BadRequestException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .errors(singletonList(ex.getMessage()))
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        log.error("Error handler = {}", ex.getMessage(), ex);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handlerCustomerDocumentAlreadyExistException(NotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .errors(singletonList(ex.getMessage()))
                .code(HttpStatus.NOT_FOUND.value())
                .build();
        log.error("Error handler = {}", ex.getMessage(), ex);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerException(Exception ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .errors(singletonList("Internal error"))
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        log.error("Error handler = {}", ex.getMessage(), ex);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
