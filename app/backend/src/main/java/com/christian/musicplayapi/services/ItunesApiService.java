package com.christian.musicplayapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItunesApiService {

  private final RestTemplate restTemplate;

  @Autowired
  public ItunesApiService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Object getMusics(long id) {
    String url = "https://itunes.apple.com/lookup?id=" + id + "&entity=song";
    return restTemplate.getForObject(url, Object.class);
  }

  public Object searchAlbums(String artist) {
    String artistNameURL = artist.replace(" ", "+");
    String url = "https://itunes.apple.com/search?entity=album&term=" + artistNameURL
        + "&attribute=allArtistTerm";
    return restTemplate.getForObject(url, Object.class);
  }
}