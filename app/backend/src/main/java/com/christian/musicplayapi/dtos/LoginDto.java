package com.christian.musicplayapi.dtos;

public record LoginDto(String email, String password) {

  /**
   * Bloco de inicialização.
   */
  public LoginDto {
    if (password == null || password.length() < 6) {
      throw new IllegalArgumentException("Password must be at least 6 characters long");
    }
  }
}
