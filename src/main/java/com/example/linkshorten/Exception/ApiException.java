package com.example.linkshorten.Exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 22/09/20
 **/
public class ApiException {
  private final String message;
  private final Throwable throwable;
  private final HttpStatus httpStatus;
  private final ZonedDateTime zonedDateTime;

  public ApiException(String message,
                      Throwable throwable,
                      HttpStatus httpStatus,
                      ZonedDateTime zonedDateTime) {
    this.message = message;
    this.throwable = throwable;
    this.httpStatus = httpStatus;
    this.zonedDateTime = zonedDateTime;
  }


}
