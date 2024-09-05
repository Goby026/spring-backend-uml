package dev.uml.selva.services;

import dev.uml.selva.entities.Cita;
import dev.uml.selva.repositories.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService implements DAOService<Cita>{

    private CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public Cita registrar(Cita p) throws Exception {
        return this.citaRepository.save(p);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        this.citaRepository.deleteById(id);
    }

    @Override
    public Cita obtener(Long id) throws Exception {
        return this.citaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Cita> listar() throws Exception {
        return this.citaRepository.findAll();
    }
}
