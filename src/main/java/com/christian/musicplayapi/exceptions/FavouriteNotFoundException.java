package com.christian.musicplayapi.exceptions;

public class FavouriteNotFoundException extends RuntimeException {

  public FavouriteNotFoundException(String message) {
    super(message);
  }
}
