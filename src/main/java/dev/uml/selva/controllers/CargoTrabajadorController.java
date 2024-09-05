package dev.uml.selva.controllers;

import dev.uml.selva.entities.CargoTrabajador;
import dev.uml.selva.services.CargoTrabajadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/uml1/selva/v1")
public class CargoTrabajadorController {
    
    private final CargoTrabajadorService service;

    public CargoTrabajadorController(CargoTrabajadorService service) {
        this.service = service;
    }

    @GetMapping("/cargos")
    public ResponseEntity<HashMap<String, List<CargoTrabajador>>> list() throws Exception {
        List<CargoTrabajador> cargos = this.service.listar();
        HashMap<String, List<CargoTrabajador>> resp = new HashMap<>();
        resp.put("cargos", cargos);
        return new ResponseEntity<HashMap<String, List<CargoTrabajador>>>(resp, HttpStatus.OK);
    }

    @GetMapping("/cargos/{id}")
    public ResponseEntity<CargoTrabajador> get(@PathVariable(value = "id") Long id) throws Exception {
        CargoTrabajador cargo = this.service.obtener(id);
        return new ResponseEntity<CargoTrabajador>(cargo, HttpStatus.OK);
    }

    @PostMapping("/cargos")
    public ResponseEntity<CargoTrabajador> add(@RequestBody CargoTrabajador p) throws Exception {
        try {
            CargoTrabajador cargo = this.service.registrar(p);
            return new ResponseEntity<CargoTrabajador>(cargo, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<CargoTrabajador>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/cargos/{id}")
    public ResponseEntity<CargoTrabajador> update(@RequestBody CargoTrabajador p,@PathVariable Long id) throws Exception {
        try {
            CargoTrabajador cargo = this.service.registrar(p);
            return new ResponseEntity<CargoTrabajador>(cargo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<CargoTrabajador>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cargos/{id}")
    public ResponseEntity<CargoTrabajador> delete(@PathVariable(value = "id") Long id) throws Exception {
        try {
            this.service.eliminar(id);
            return new ResponseEntity<CargoTrabajador>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<CargoTrabajador>(HttpStatus.NOT_FOUND);
        }
    }
    
    
}
