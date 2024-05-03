package com.christian.musicplayapi.services;

import com.christian.musicplayapi.dtos.UserRequestDto;
import com.christian.musicplayapi.exceptions.UserNotFoundException;
import com.christian.musicplayapi.models.entities.User;
import com.christian.musicplayapi.models.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(long id) {
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

}
