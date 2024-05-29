package com.christian.musicplayapi.exceptions;

public class FavoriteNotFoundException extends RuntimeException {

  public FavoriteNotFoundException(String message) {
    super(message);
  }
}
