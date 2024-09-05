package dev.uml.selva.services;

import dev.uml.selva.entities.CargoTrabajador;
import dev.uml.selva.repositories.CargoTrabajadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoTrabajadorService implements DAOService<CargoTrabajador> {

    private final CargoTrabajadorRepository repository;

    public CargoTrabajadorService(CargoTrabajadorRepository repository) {
        this.repository = repository;
    }

    @Override
    public CargoTrabajador registrar(CargoTrabajador p) throws Exception {
        return this.repository.save(p);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        this.repository.deleteById(id);
    }

    @Override
    public CargoTrabajador obtener(Long id) throws Exception {
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public List<CargoTrabajador> listar() throws Exception {
        return this.repository.findAll();
    }
}
