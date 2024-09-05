package dev.uml.selva.services;

import dev.uml.selva.entities.Menu;
import dev.uml.selva.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements DAOService<Menu> {

    private MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu registrar(Menu p) throws Exception {
        return this.menuRepository.save(p);
    }

    @Override
    public void eliminar(Long id) throws Exception {
        this.menuRepository.deleteById(id);
    }

    @Override
    public Menu obtener(Long id) throws Exception {
        return this.menuRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Menu> listar() throws Exception {
        return this.menuRepository.findAll();
    }
}
