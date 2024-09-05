package dev.uml.selva.services;

import dev.uml.selva.entities.Trabajador;
import dev.uml.selva.repositories.TrabajadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorService implements DAOService<Trabajador> {

    private final TrabajadorRepository trabajadorRepository;

    public TrabajadorService(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    @Override
    public Trabajador registrar(Trabajador p) throws Exception {
        return this.trabajadorRepository.save(p);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        this.trabajadorRepository.deleteById(id);
    }

    @Override
    public Trabajador obtener(Long id) throws Exception {
        return this.trabajadorRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Trabajador> listar() throws Exception {
        return trabajadorRepository.findAll();
    }
}
