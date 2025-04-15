package org.example.onderhoudsbuddydal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.onderhoudsbuddydal.Entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
}

