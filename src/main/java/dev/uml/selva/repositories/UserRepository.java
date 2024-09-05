package dev.uml.selva.repositories;

import dev.uml.selva.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
