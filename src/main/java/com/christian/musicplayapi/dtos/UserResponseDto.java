package com.christian.musicplayapi.dtos;

import com.christian.musicplayapi.models.entities.User;
import java.util.List;

public record UserResponseDto(long id, String email, String username,
                              List<FavouriteDto> favourites) {

  public static UserResponseDto entityToDto(User user) {
    List<FavouriteDto> favouriteDtos = user.getFavourites().stream()
        .map(FavouriteDto::entityToDto)
        .toList();

    return new UserResponseDto(user.getId(), user.getEmail(), user.getUsername(), favouriteDtos);
  }
}
