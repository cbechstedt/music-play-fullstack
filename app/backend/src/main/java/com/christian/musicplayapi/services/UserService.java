package com.christian.musicplayapi.services;

import com.christian.musicplayapi.dtos.UserRequestDto;
import com.christian.musicplayapi.exceptions.FavoriteNotFoundException;
import com.christian.musicplayapi.exceptions.UserNotFoundException;
import com.christian.musicplayapi.models.entities.Favorite;
import com.christian.musicplayapi.models.entities.User;
import com.christian.musicplayapi.models.repositories.FavoriteRepository;
import com.christian.musicplayapi.models.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final FavoriteRepository favoriteRepository;

  @Autowired
  public UserService(UserRepository userRepository, FavoriteService favoriteService,
      FavoriteRepository favoriteRepository) {
    this.userRepository = userRepository;
    this.favoriteRepository = favoriteRepository;
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(long id) throws UserNotFoundException {
    Optional<User> user = userRepository.findById(id);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User not found.");
    }
    return user.get();
  }

  public User update(long id, UserRequestDto updatedUser) {
    User user = this.findById(id);
    user.setEmail(updatedUser.email());
    user.setUsername(updatedUser.username());
    user.setPassword(updatedUser.password());

    return this.save(user);
  }

  public void delete(long id) {
    User user = this.findById(id);
    userRepository.delete(user);
  }

  public User addFavoriteToUser(long userId, long favoriteId) throws UserNotFoundException {
    User user = userRepository.findById(userId).orElseThrow();
    Favorite favorite = favoriteRepository.findById(favoriteId)
        .orElseThrow();
    user.getFavorites().add(favorite);
    return userRepository.save(user);
  }

  public User removeFavoriteFromUser(long userId, long favoriteId)
      throws UserNotFoundException, FavoriteNotFoundException {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new UserNotFoundException("User not found."));
    Favorite favorite = favoriteRepository.findByTrackId(favoriteId)
        .orElseThrow(() -> new FavoriteNotFoundException("Favorite not found."));

    boolean removed = user.getFavorites().remove(favorite);
    if (!removed) {
      throw new FavoriteNotFoundException("Favorite not found in user's favorites.");
    }

    return userRepository.save(user);
  }


  public User authenticate(String email, String password) {
    return userRepository.findByEmailAndPassword(email, password).orElse(null);
  }
}
