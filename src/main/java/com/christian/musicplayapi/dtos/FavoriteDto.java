package com.christian.musicplayapi.dtos;

import com.christian.musicplayapi.models.entities.Favorite;

public record FavoriteDto(long id, String name) {

  public static FavoriteDto entityToDto(Favorite favorite) {
    return new FavoriteDto(favorite.getId(), favorite.getName());
  }

  public Favorite dtoToEntity() {
    Favorite favorite = new Favorite();
    favorite.setName(this.name);
    return favorite;
  }
}
