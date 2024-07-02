package com.christian.musicplayapi.services;

import com.christian.musicplayapi.exceptions.FavoriteNotFoundException;
import com.christian.musicplayapi.models.entities.Favorite;
import com.christian.musicplayapi.models.repositories.FavoriteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

  private final FavoriteRepository favoriteRepository;

  @Autowired
  public FavoriteService(FavoriteRepository favoriteRepository) {
    this.favoriteRepository = favoriteRepository;
  }

  public List<Favorite> findAll() {
    return favoriteRepository.findAll();
  }

  public Favorite findById(long id) {
    Optional<Favorite> favorite = favoriteRepository.findById(id);
    if (favorite.isEmpty()) {
      throw new FavoriteNotFoundException("Favorite song not found");
    }
    return favorite.get();
  }

  public Favorite save(Favorite favorite) {
    return favoriteRepository.save(favorite);
  }

  public void delete(long id) {
    Favorite favorite = findById(id);
    favoriteRepository.delete(favorite);
  }

  public Optional<Favorite> findByTrackId(long trackId) {
    return favoriteRepository.findByTrackId(trackId);
  }
}
