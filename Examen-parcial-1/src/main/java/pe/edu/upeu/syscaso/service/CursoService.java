package pe.edu.upeu.syscaso.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.syscaso.entity.Curso;

public interface CursoService {
	Curso create(Curso a);
	Curso update(Curso a);
	void delete(Long id);
	Optional<Curso>read(Long id);
	List<Curso>readAll();
}
