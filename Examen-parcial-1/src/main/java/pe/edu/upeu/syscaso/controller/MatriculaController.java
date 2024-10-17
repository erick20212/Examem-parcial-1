package pe.edu.upeu.syscaso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.edu.upeu.syscaso.entity.Matricula;
import pe.edu.upeu.syscaso.service.MatriculaService;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
    
    @Autowired
    private MatriculaService service;
    
    @GetMapping
    public ResponseEntity<List<Matricula>> readAll() {
        try {
            List<Matricula> lista = service.readAll();
            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping
    public ResponseEntity<Matricula> create(@Valid @RequestBody Matricula obj) {
        try {
            Matricula objeto = service.create(obj);
            return new ResponseEntity<>(objeto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Matricula> getMatriculaId(@PathVariable Long id) {
        try {
            Optional<Matricula> objeto = service.read(id);
            if (objeto.isPresent()) {
                return new ResponseEntity<>(objeto.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delMatricula(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{id}")
	public ResponseEntity<Matricula> updateMatricula(@PathVariable Long id, @Valid @RequestBody Matricula obj) {
	    Optional<Matricula> objeto = service.read(id);
	    if (objeto.isPresent()) {
	        // Aquí se asume que el servicio actualiza el objeto y lo retorna
	    	Matricula actualizado = service.update(obj);
	        return new ResponseEntity<>(actualizado, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 si no se encuentra el objeto
	    }		
	}
}
