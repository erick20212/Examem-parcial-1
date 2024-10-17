package pe.edu.upeu.syscaso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.edu.upeu.syscaso.entity.Curso;
import pe.edu.upeu.syscaso.entity.Empleado;
import pe.edu.upeu.syscaso.service.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
	@Autowired
	private CursoService service;
	
	@GetMapping
	public ResponseEntity<List<Curso>> readAll() {
		try {
			List<Curso> lista = service.readAll();
			if(lista.isEmpty()){
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(lista, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping
	public ResponseEntity<Curso> create(@Valid @RequestBody Curso obj){
		try {
			Curso objeto = service.create(obj);
			return new ResponseEntity<>(objeto, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Curso> getCursoId(@PathVariable Long id){
		try {
			Curso objeto = service.read(id).get();
			return new ResponseEntity<>(objeto, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Curso> updateCursoo(@PathVariable Long id, @Valid @RequestBody Curso obj) {
	    Optional<Curso> objeto = service.read(id);
	    if (objeto.isPresent()) {
	        // Aquí se asume que el servicio actualiza el objeto y lo retorna
	    	Curso actualizado = service.update(obj);
	        return new ResponseEntity<>(actualizado, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 si no se encuentra el objeto
	    }		
	}
}