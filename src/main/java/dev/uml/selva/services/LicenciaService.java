package dev.uml.selva.services;

import dev.uml.selva.entities.Licencia;
import dev.uml.selva.repositories.LicenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenciaService implements DAOService<Licencia>{

    private final LicenciaRepository licenciaRepository;

    public LicenciaService(LicenciaRepository licenciaRepository) {
        this.licenciaRepository = licenciaRepository;
    }

    @Override
    public Licencia registrar(Licencia p) throws Exception {
        return this.licenciaRepository.save(p);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        this.licenciaRepository.deleteById(id);
    }

    @Override
    public Licencia obtener(Long id) throws Exception {
        return this.licenciaRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Licencia> listar() throws Exception {
        return this.licenciaRepository.findAll();
    }
}
