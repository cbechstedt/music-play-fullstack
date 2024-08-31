package com.christian.musicplayapi.controllers;

import com.christian.musicplayapi.services.ItunesApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itunes")
public class ItunesApiController {

  private final ItunesApiService itunesApiService;

  @Autowired
  public ItunesApiController(ItunesApiService itunesApiService) {
    this.itunesApiService = itunesApiService;
  }

  @GetMapping("/musics/{id}")
  public ResponseEntity<Object> getMusics(@PathVariable long id) {
    Object musics = itunesApiService.getMusics(id);
    return ResponseEntity.ok(musics);
  }

  @GetMapping("/albums")
  public ResponseEntity<Object> searchAlbums(@RequestParam String artist) {
    Object albums = itunesApiService.searchAlbums(artist);
    return ResponseEntity.ok(albums);
  }
}