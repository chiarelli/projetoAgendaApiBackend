package br.com.cotiinformatica.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleException(MethodArgumentNotValidException e, WebRequest request) {
    var erros = e.getBindingResult().
      getFieldErrors().
      stream().
      map(error -> "Campo: " + error.getField() + " - " + error.getDefaultMessage()).
      toList();

    var body = new HashMap<String, Object>();
      body.put("status", HttpStatus.BAD_REQUEST.value());
      body.put("errors", erros);
      body.put("path", request.getDescription(false));

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }
}
