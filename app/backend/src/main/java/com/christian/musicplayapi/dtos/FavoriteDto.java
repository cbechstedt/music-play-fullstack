package com.christian.musicplayapi.dtos;

import com.christian.musicplayapi.models.entities.Favorite;

public record FavoriteDto(long id, long trackId, String trackName, String previewUrl,
                          String artistName, String albumName) {

  public static FavoriteDto entityToDto(Favorite favorite) {
    return new FavoriteDto(favorite.getId(), favorite.getTrackId(), favorite.getTrackName(),
        favorite.getPreviewUrl(), favorite.getArtistName(), favorite.getAlbumName());
  }

  public Favorite dtoToEntity() {
    Favorite favorite = new Favorite();
    favorite.setTrackId(this.trackId);
    favorite.setTrackName(this.trackName);
    favorite.setPreviewUrl(this.previewUrl);
    favorite.setArtistName(this.artistName);
    favorite.setAlbumName(this.albumName);
    return favorite;
  }
}
