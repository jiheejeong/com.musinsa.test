package com.musinsa.test.support;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ExceptionHandling {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    log.error("MethodArgumentNotValidException", ex);
    BindingResult bindingResult = ex.getBindingResult();
    final List<ErrorResponse.FieldError> fieldErrors = new ArrayList<>();
    for (FieldError fieldError : bindingResult.getFieldErrors()) {
      fieldErrors.add(ErrorResponse.FieldError.builder().field(fieldError.getField()).message(fieldError.getDefaultMessage()).build());
    }
    return new ResponseEntity<>(ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).resultMsg(ex.getTypeMessageCode()).errors(fieldErrors).build(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(EntityNotFoundException.class)
  protected ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
    log.error("EntityNotFoundException", ex);
    return new ResponseEntity<>(ErrorResponse.builder().status(HttpStatus.NOT_FOUND.value()).resultMsg(ex.getMessage()).build(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  protected final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
    log.error("Exception", ex);
    return new ResponseEntity<>(ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).resultMsg(ex.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
