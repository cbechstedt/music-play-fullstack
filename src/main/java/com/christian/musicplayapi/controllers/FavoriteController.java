package com.christian.musicplayapi.controllers;

import com.christian.musicplayapi.dtos.FavoriteDto;
import com.christian.musicplayapi.exceptions.FavoriteNotFoundException;
import com.christian.musicplayapi.models.entities.Favorite;
import com.christian.musicplayapi.services.FavoriteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

  private final FavoriteService favoriteService;

  @Autowired
  public FavoriteController(FavoriteService favoriteService) {
    this.favoriteService = favoriteService;
  }

  @GetMapping
  public ResponseEntity<List<FavoriteDto>> findAll() {
    List<Favorite> favorites = favoriteService.findAll();
    List<FavoriteDto> favoriteDtos = favorites.stream()
        .map(FavoriteDto::entityToDto).toList();
    return ResponseEntity.status(200).body(favoriteDtos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<FavoriteDto> findById(@PathVariable("id") long id)
      throws FavoriteNotFoundException {
    Favorite favorite = favoriteService.findById(id);
    FavoriteDto favoriteDto = FavoriteDto.entityToDto(favorite);
    return ResponseEntity.status(200).body(favoriteDto);
  }

  @PostMapping
  public ResponseEntity<FavoriteDto> create(@RequestBody FavoriteDto favoriteDto) {
    Favorite favorite = favoriteDto.dtoToEntity();
    Favorite savedFavorite = favoriteService.save(favorite);
    FavoriteDto savedFavoriteDto = FavoriteDto.entityToDto(savedFavorite);
    return ResponseEntity.status(201).body(savedFavoriteDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") long id) {
    favoriteService.delete(id);
    return ResponseEntity.status(204).build();
  }
}
