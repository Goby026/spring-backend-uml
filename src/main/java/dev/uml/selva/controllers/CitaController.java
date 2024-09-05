package dev.uml.selva.controllers;

import dev.uml.selva.entities.Cita;
import dev.uml.selva.services.CitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/uml1/selva/v1")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/citas")
    public ResponseEntity<HashMap<String, List<Cita>>> list() throws Exception {
        List<Cita> citas = this.citaService.listar();
        HashMap<String, List<Cita>> resp = new HashMap<>();
        resp.put("citas", citas);
        return new ResponseEntity<HashMap<String, List<Cita>>>(resp, HttpStatus.OK);
    }

    @GetMapping("/citas/{id}")
    public ResponseEntity<Cita> get(@PathVariable(value = "id") Long id) throws Exception {
        Cita cita = citaService.obtener(id);
        return new ResponseEntity<Cita>(cita, HttpStatus.OK);
    }

    @PostMapping("/citas")
    public ResponseEntity<Cita> add(@RequestBody Cita p) throws Exception {
        try {
            Cita cita = citaService.registrar(p);
            return new ResponseEntity<Cita>(cita, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Cita>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/citas/{id}")
    public ResponseEntity<Cita> update(@RequestBody Cita p,@PathVariable Long id) throws Exception {
        try {
            Cita cita = citaService.registrar(p);
            return new ResponseEntity<Cita>(cita, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Cita>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/citas/{id}")
    public ResponseEntity<Cita> delete(@PathVariable(value = "id") Long id) throws Exception {
        try {
            citaService.eliminar(id);
            return new ResponseEntity<Cita>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Cita>(HttpStatus.NOT_FOUND);
        }
    }

}
