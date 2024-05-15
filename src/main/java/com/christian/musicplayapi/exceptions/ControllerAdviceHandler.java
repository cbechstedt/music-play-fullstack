package com.christian.musicplayapi.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<String> handleUserNotFound(UserNotFoundException e) {
    return ResponseEntity.status(404).body(e.getMessage());
  }

  @ExceptionHandler(FavouriteNotFoundException.class)
  public ResponseEntity<String> handleFavouriteNotFound(FavouriteNotFoundException e) {
    return ResponseEntity.status(404).body(e.getMessage());
  }
}
