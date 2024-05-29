package com.christian.musicplayapi.dtos;

import com.christian.musicplayapi.models.entities.User;
import java.util.List;

public record UserResponseDto(long id, String email, String username,
                              List<FavoriteDto> favorites) {

  public static UserResponseDto entityToDto(User user) {
    List<FavoriteDto> favoriteDtos = user.getFavorites().stream()
        .map(FavoriteDto::entityToDto)
        .toList();

    return new UserResponseDto(user.getId(), user.getEmail(), user.getUsername(), favoriteDtos);
  }
}
