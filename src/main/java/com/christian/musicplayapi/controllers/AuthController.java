package com.christian.musicplayapi.controllers;

import com.christian.musicplayapi.dtos.UserRequestDto;
import com.christian.musicplayapi.dtos.UserResponseDto;
import com.christian.musicplayapi.exceptions.UserNotFoundException;
import com.christian.musicplayapi.models.entities.User;
import com.christian.musicplayapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserService userService;

  @Autowired
  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/login")
  public ResponseEntity<UserResponseDto> login(@RequestBody UserRequestDto userDto) {
    User user = userService.authenticate(userDto.email(), userDto.password());
    if (user == null) {
      throw new UserNotFoundException("Invalid email or password");
    }
    UserResponseDto userResponseDto = UserResponseDto.entityToDto(user);
    return ResponseEntity.status(200).body(userResponseDto);
  }

  @PostMapping("/register")
  public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto userDto) {
    User user = userDto.dtoToEntity();
    userService.save(user);
    UserResponseDto userResponseDto = UserResponseDto.entityToDto(user);
    return ResponseEntity.status(201).body(userResponseDto);
  }
}
