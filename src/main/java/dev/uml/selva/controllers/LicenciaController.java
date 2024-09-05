package dev.uml.selva.controllers;

import dev.uml.selva.entities.Licencia;
import dev.uml.selva.services.LicenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/uml1/selva/v1")
public class LicenciaController {
    
    private final LicenciaService licenciaService;

    public LicenciaController(LicenciaService licenciaService) {
        this.licenciaService = licenciaService;
    }

    @GetMapping("/licencias")
    public ResponseEntity<HashMap<String, List<Licencia>>> list() throws Exception {
        List<Licencia> licencias = this.licenciaService.listar();
        HashMap<String, List<Licencia>> resp = new HashMap<>();
        resp.put("licencias", licencias);
        return new ResponseEntity<HashMap<String, List<Licencia>>>(resp, HttpStatus.OK);
    }

    @GetMapping("/licencias/{id}")
    public ResponseEntity<Licencia> get(@PathVariable(value = "id") Long id) throws Exception {
        Licencia licencia = licenciaService.obtener(id);
        return new ResponseEntity<Licencia>(licencia, HttpStatus.OK);
    }

    @PostMapping("/licencias")
    public ResponseEntity<Licencia> add(@RequestBody Licencia p) throws Exception {
        try {
            Licencia cita = licenciaService.registrar(p);
            return new ResponseEntity<Licencia>(cita, HttpStatus.CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Licencia>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/licencias/{id}")
    public ResponseEntity<Licencia> update(@RequestBody Licencia p,@PathVariable Long id) throws Exception {
        try {
            Licencia licencia = licenciaService.registrar(p);
            return new ResponseEntity<Licencia>(licencia, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Licencia>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/licencias/{id}")
    public ResponseEntity<Licencia> delete(@PathVariable(value = "id") Long id) throws Exception {
        try {
            licenciaService.eliminar(id);
            return new ResponseEntity<Licencia>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Licencia>(HttpStatus.NOT_FOUND);
        }
    }
}
