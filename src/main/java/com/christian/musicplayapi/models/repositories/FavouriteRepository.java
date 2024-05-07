package com.christian.musicplayapi.models.repositories;

import com.christian.musicplayapi.models.entities.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

}
