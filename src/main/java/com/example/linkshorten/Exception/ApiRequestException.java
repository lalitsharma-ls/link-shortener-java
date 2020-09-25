package com.example.linkshorten.Exception;

/**
 * @project linkshorten
 * @Author Lalit Sharma on 22/09/20
 **/
public class ApiRequestException extends RuntimeException{

  public ApiRequestException(String message) {
    super(message);
  }

  public ApiRequestException(String message, Throwable cause) {
    super(message, cause);
  }

}
