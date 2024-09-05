package dev.uml.selva.controllers;

import dev.uml.selva.entities.Sede;
import dev.uml.selva.services.SedeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/uml1/selva/v1")
public class SedeController {
    
    private final SedeService service;

    public SedeController(SedeService service) {
        this.service = service;
    }
    
    @GetMapping("/sedes")
    public ResponseEntity<HashMap<String, List<Sede>>> list() throws Exception {
        List<Sede> sedes = this.service.listar();
        HashMap<String, List<Sede>> resp = new HashMap<>();
        resp.put("sedes", sedes);
        return new ResponseEntity<HashMap<String, List<Sede>>>(resp, HttpStatus.OK);
    }

    @PostMapping("/sedes")
    public ResponseEntity<Sede> add(@RequestBody Sede p) throws Exception {
        try {
            Sede sede = service.registrar(p);
            return new ResponseEntity<Sede>(sede, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Sede>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/sedes/{id}")
    public ResponseEntity<Sede> update(@RequestBody Sede p, @PathVariable Long id) throws Exception {
        try {
            Sede sede = service.registrar(p);
            return new ResponseEntity<Sede>(sede, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Sede>(HttpStatus.NOT_FOUND);
        }
    }
}
