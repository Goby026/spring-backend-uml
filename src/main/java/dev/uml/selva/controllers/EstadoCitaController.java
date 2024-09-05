package dev.uml.selva.controllers;

import dev.uml.selva.entities.EstadoCita;
import dev.uml.selva.services.EstadoCitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/uml1/selva/v1")
public class EstadoCitaController{

    private EstadoCitaService estadoCitaService;

    public EstadoCitaController(EstadoCitaService estadoCitaService) {
        this.estadoCitaService = estadoCitaService;
    }

    @GetMapping("/estados")
    public ResponseEntity<HashMap<String, List<EstadoCita>>> list() throws Exception {
        List<EstadoCita> estadoCitas = this.estadoCitaService.listar();
        HashMap<String, List<EstadoCita>> resp = new HashMap<>();
        resp.put("estados", estadoCitas);
        return new ResponseEntity<HashMap<String, List<EstadoCita>>>(resp, HttpStatus.OK);
    }

    @GetMapping("/estados/{id}")
    public ResponseEntity<EstadoCita> get(@PathVariable(value = "id") Long id) throws Exception {
        EstadoCita estadoCita = this.estadoCitaService.obtener(id);
        return new ResponseEntity<EstadoCita>(estadoCita, HttpStatus.OK);
    }

    @PostMapping("/estados")
    public ResponseEntity<EstadoCita> add(@RequestBody EstadoCita p) throws Exception {
        try {
            EstadoCita estadoCita = estadoCitaService.registrar(p);
            return new ResponseEntity<EstadoCita>(estadoCita, HttpStatus.CREATED);
        }catch (NoSuchElementException e){
            return new ResponseEntity<EstadoCita>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/estados/{id}")
    public ResponseEntity<EstadoCita> update(@RequestBody EstadoCita p, @PathVariable(value = "id") Long id) throws Exception {
        try {
            EstadoCita estadoCita = this.estadoCitaService.registrar(p);
            return new ResponseEntity<EstadoCita>(estadoCita, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<EstadoCita>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/estados/{id}")
    public ResponseEntity<EstadoCita> delete(@PathVariable(value = "id") Long id) throws Exception {
        try {
            this.estadoCitaService.eliminar(id);
            return new ResponseEntity<EstadoCita>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<EstadoCita>(HttpStatus.NOT_FOUND);
        }
    }
}
