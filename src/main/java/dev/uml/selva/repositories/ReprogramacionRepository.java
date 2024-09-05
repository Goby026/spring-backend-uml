package dev.uml.selva.repositories;

import dev.uml.selva.entities.Reprogramacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReprogramacionRepository extends JpaRepository<Reprogramacion, Long> {
}
