package dev.uml.selva.controllers;

import dev.uml.selva.entities.Trabajador;
import dev.uml.selva.services.TrabajadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/uml1/selva/v1")
public class TrabajadorController {
    private final TrabajadorService trabajadorService;

    public TrabajadorController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @GetMapping("/trabajadores")
    public ResponseEntity<HashMap<String, List<Trabajador>>> list() throws Exception {
        List<Trabajador> trabajadores = this.trabajadorService.listar();
        HashMap<String, List<Trabajador>> resp = new HashMap<>();
        resp.put("trabajadores", trabajadores);
        return new ResponseEntity<HashMap<String, List<Trabajador>>>(resp, HttpStatus.OK);
    }

    @GetMapping("/trabajadores/{id}")
    public ResponseEntity<Trabajador> get(@PathVariable(value = "id") Long id) throws Exception {
        Trabajador trabajador = this.trabajadorService.obtener(id);
        return new ResponseEntity<Trabajador>(trabajador, HttpStatus.OK);
    }

    @PostMapping("/trabajadores")
    public ResponseEntity<Trabajador> add(@RequestBody Trabajador p) throws Exception {
        try {
            Trabajador trabajador = this.trabajadorService.registrar(p);
            return new ResponseEntity<Trabajador>(trabajador, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Trabajador>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/trabajadores/{id}")
    public ResponseEntity<Trabajador> update(@RequestBody Trabajador p,@PathVariable Long id) throws Exception {
        try {
            Trabajador trabajador = this.trabajadorService.registrar(p);
            return new ResponseEntity<Trabajador>(trabajador, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Trabajador>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/trabajadores/{id}")
    public ResponseEntity<Trabajador> delete(@PathVariable(value = "id") Long id) throws Exception {
        try {
            this.trabajadorService.eliminar(id);
            return new ResponseEntity<Trabajador>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Trabajador>(HttpStatus.NOT_FOUND);
        }
    }
}
