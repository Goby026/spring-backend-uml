package dev.uml.selva.services;

import dev.uml.selva.entities.Reprogramacion;
import dev.uml.selva.repositories.ReprogramacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReprogramacionService implements DAOService<Reprogramacion>{

    private ReprogramacionRepository reprogramacionRepository;

    public ReprogramacionService(ReprogramacionRepository reprogramacionRepository) {
        this.reprogramacionRepository = reprogramacionRepository;
    }

    @Override
    public Reprogramacion registrar(Reprogramacion p) throws Exception {
        return this.reprogramacionRepository.save(p);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        this.reprogramacionRepository.deleteById(id);
    }

    @Override
    public Reprogramacion obtener(Long id) throws Exception {
        return this.reprogramacionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Reprogramacion> listar() throws Exception {
        return this.reprogramacionRepository.findAll();
    }
}
