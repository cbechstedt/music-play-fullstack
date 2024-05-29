package com.christian.musicplayapi.models.repositories;

import com.christian.musicplayapi.models.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

}
