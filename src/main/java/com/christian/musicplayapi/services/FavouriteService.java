package com.christian.musicplayapi.services;

import com.christian.musicplayapi.models.entities.Favourite;
import com.christian.musicplayapi.models.repositories.FavouriteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavouriteService {

  private final FavouriteRepository favouriteRepository;

  @Autowired
  public FavouriteService(FavouriteRepository favouriteRepository) {
    this.favouriteRepository = favouriteRepository;
  }

  public List<Favourite> findAll() {
    return favouriteRepository.findAll();
  }

  public Favourite findById(long id) {
    Optional<Favourite> favourite = favouriteRepository.findById(id);
    if (favourite.isEmpty()) {
      throw new FavouriteNotFoundException("Favorite song not found");
    }
    return favourite.get();
  }

  public Favourite save(Favourite favourite) {
    return favouriteRepository.save(favourite);
  }

  public void delete(long id) {
    favouriteRepository.deleteById(id);
  }
}
