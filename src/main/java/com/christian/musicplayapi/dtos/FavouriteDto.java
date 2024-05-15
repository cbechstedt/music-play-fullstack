package com.christian.musicplayapi.dtos;

import com.christian.musicplayapi.models.entities.Favourite;

public record FavouriteDto(long id, String name) {

  public static FavouriteDto entityToDto(Favourite favourite) {
    return new FavouriteDto(favourite.getId(), favourite.getName());
  }

  public Favourite dtoToEntity() {
    Favourite favourite = new Favourite();
    favourite.setName(this.name);
    return favourite;
  }
}
