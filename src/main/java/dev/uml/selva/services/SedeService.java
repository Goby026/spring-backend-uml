package dev.uml.selva.services;

import dev.uml.selva.entities.Sede;
import dev.uml.selva.repositories.SedeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeService implements DAOService<Sede>{

    private final SedeRepository sedeRepository;

    public SedeService(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    @Override
    public Sede registrar(Sede p) throws Exception {
        return this.sedeRepository.save(p);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        this.sedeRepository.deleteById(id);
    }

    @Override
    public Sede obtener(Long id) throws Exception {
        return this.sedeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Sede> listar() throws Exception {
        return this.sedeRepository.findAll();
    }
}
