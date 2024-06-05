package com.christian.musicplayapi.models.repositories;

import com.christian.musicplayapi.models.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmailAndPassword(String email, String password);
}
