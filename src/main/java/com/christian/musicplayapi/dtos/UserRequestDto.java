package com.christian.musicplayapi.dtos;

import com.christian.musicplayapi.models.entities.User;

public record UserRequestDto(String email, String username, String password) {

  /**
   * Bloco de inicialização.
   */
  public UserRequestDto {
    if (password == null || password.length() < 6) {
      throw new IllegalArgumentException("Password must be at least 6 characters long");
    }
  }

  /**
   * Método para transformar dto em entidade.
   */
  public User dtoToEntity() {
    User user = new User();
    user.setEmail(this.email);
    user.setUsername(this.username);
    user.setPassword(this.password);
    return user;
  }
}
