package com.christian.musicplayapi.controllers;

import com.christian.musicplayapi.dtos.FavouriteDto;
import com.christian.musicplayapi.exceptions.FavouriteNotFoundException;
import com.christian.musicplayapi.models.entities.Favourite;
import com.christian.musicplayapi.services.FavouriteService;
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
@RequestMapping("/favourites")
public class FavouriteController {

  private final FavouriteService favouriteService;

  @Autowired
  public FavouriteController(FavouriteService favouriteService) {
    this.favouriteService = favouriteService;
  }

  @GetMapping
  public ResponseEntity<List<FavouriteDto>> findAll() {
    List<Favourite> favourites = favouriteService.findAll();
    List<FavouriteDto> favouriteDtos = favourites.stream()
        .map(FavouriteDto::entityToDto).toList();
    return ResponseEntity.status(200).body(favouriteDtos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<FavouriteDto> findById(@PathVariable("id") long id)
      throws FavouriteNotFoundException {
    Favourite favourite = favouriteService.findById(id);
    FavouriteDto favouriteDto = FavouriteDto.entityToDto(favourite);
    return ResponseEntity.status(200).body(favouriteDto);
  }

  @PostMapping
  public ResponseEntity<FavouriteDto> create(@RequestBody FavouriteDto favouriteDto) {
    Favourite favourite = favouriteDto.dtoToEntity();
    Favourite savedFavourite = favouriteService.save(favourite);
    FavouriteDto savedFavouriteDto = FavouriteDto.entityToDto(savedFavourite);
    return ResponseEntity.status(201).body(savedFavouriteDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") long id) {
    favouriteService.delete(id);
    return ResponseEntity.status(204).build();
  }
}
