package dev.uml.selva.repositories;

import dev.uml.selva.entities.CargoTrabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoTrabajadorRepository extends JpaRepository<CargoTrabajador, Long> {
}
