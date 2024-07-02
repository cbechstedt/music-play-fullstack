package com.christian.musicplayapi.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "favorites")
public class Favorite {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long trackId;
  private String trackName;
  private String previewUrl;
  private String artistName;
  private String albumName;

  @ManyToMany(mappedBy = "favorites")
  @JsonIgnore
  private List<User> users;

  public Favorite(Long id, Long trackId, String trackName, String previewUrl, String artistName,
      String albumName, List<User> users) {
    this.id = id;
    this.trackId = trackId;
    this.trackName = trackName;
    this.previewUrl = previewUrl;
    this.artistName = artistName;
    this.albumName = albumName;
    this.users = users;
  }

  public Favorite() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTrackId() {
    return trackId;
  }

  public void setTrackId(Long trackId) {
    this.trackId = trackId;
  }

  public String getTrackName() {
    return trackName;
  }

  public void setTrackName(String trackName) {
    this.trackName = trackName;
  }

  public String getPreviewUrl() {
    return previewUrl;
  }

  public void setPreviewUrl(String previewUrl) {
    this.previewUrl = previewUrl;
  }

  public String getArtistName() {
    return artistName;
  }

  public void setArtistName(String artistName) {
    this.artistName = artistName;
  }

  public String getAlbumName() {
    return albumName;
  }

  public void setAlbumName(String albumName) {
    this.albumName = albumName;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}
