package com.christian.musicplayapi.controllers;

import com.christian.musicplayapi.dtos.UserRequestDto;
import com.christian.musicplayapi.dtos.UserResponseDto;
import com.christian.musicplayapi.exceptions.FavoriteNotFoundException;
import com.christian.musicplayapi.exceptions.UserNotFoundException;
import com.christian.musicplayapi.models.entities.User;
import com.christian.musicplayapi.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<List<UserResponseDto>> findAll() {
    List<User> users = userService.findAll();
    List<UserResponseDto> usersResponseDto = users.stream().map(UserResponseDto::entityToDto)
        .toList();
    return ResponseEntity.status(200).body(usersResponseDto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDto> findById(@PathVariable("id") long id)
      throws UserNotFoundException {
    User user = userService.findById(id);
    UserResponseDto userResponseDto = UserResponseDto.entityToDto(user);
    return ResponseEntity.status(200).body(userResponseDto);
  }

  @PostMapping
  public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto userDto) {
    User user = userDto.dtoToEntity();
    userService.save(user);
    UserResponseDto userResponseDto = UserResponseDto.entityToDto(user);
    return ResponseEntity.status(201).body(userResponseDto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponseDto> update(@PathVariable("id") long id,
      @RequestBody UserRequestDto userRequestDto) {
    User user = userService.update(id, userRequestDto);
    UserResponseDto userResponseDto = UserResponseDto.entityToDto(user);
    return ResponseEntity.status(200).body(userResponseDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") long id) {
    userService.delete(id);
    return ResponseEntity.status(200).body("User deleted.");
  }

  @PostMapping("/{userId}/favorites/{favoriteId}")
  public ResponseEntity<UserResponseDto> toggleFavorite(@PathVariable("userId") long userId,
      @PathVariable("favoriteId") long favoriteId)
      throws UserNotFoundException, FavoriteNotFoundException {
    User user = userService.toggleFavorite(userId, favoriteId);
    UserResponseDto userResponseDto = UserResponseDto.entityToDto(user);
    return ResponseEntity.status(200).body(userResponseDto);
  }
}
