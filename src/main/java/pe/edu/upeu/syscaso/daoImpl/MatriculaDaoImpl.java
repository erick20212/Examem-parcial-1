package pe.edu.upeu.syscaso.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.syscaso.dao.MatriculaDao;
import pe.edu.upeu.syscaso.entity.Matricula;
import pe.edu.upeu.syscaso.repository.MatriculaRepository;


@Component
public class MatriculaDaoImpl  implements MatriculaDao{

	
	@Autowired
	private MatriculaRepository  repository;
	@Override
	public Matricula create(Matricula a) {
		// TODO Auto-generated method stub
		return  repository.save(a);
	}

	@Override
	public Matricula update(Matricula a) {
		// TODO Auto-generated method stub
		return repository.save(a);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Optional<Matricula> read(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Matricula> readAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
