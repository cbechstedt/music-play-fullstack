package com.christian.musicplayapi.dtos;

import com.christian.musicplayapi.models.entities.User;

public record UserResponseDto(long id, String email, String username) {

  public static UserResponseDto entityToDto(User user) {
    return new UserResponseDto(user.getId(), user.getEmail(), user.getUsername());
  }
}
