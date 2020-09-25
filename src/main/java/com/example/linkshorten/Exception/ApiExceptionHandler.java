package com.example.linkshorten.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 22/09/20
 **/

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(value = {ApiRequestException.class})
  public  ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
      return new ResponseEntity<>(new ApiException(
              e.getMessage(), e,
              HttpStatus.BAD_REQUEST,
              ZonedDateTime.now(ZoneId.of("Z"))
      ),HttpStatus.BAD_REQUEST);
  }
}
