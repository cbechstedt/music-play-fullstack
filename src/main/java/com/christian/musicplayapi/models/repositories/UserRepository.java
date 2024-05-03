package com.christian.musicplayapi.models.repositories;

import com.christian.musicplayapi.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
