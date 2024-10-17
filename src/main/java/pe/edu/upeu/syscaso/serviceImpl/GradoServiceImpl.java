package pe.edu.upeu.syscaso.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upeu.syscaso.dao.GradoDao;
import pe.edu.upeu.syscaso.entity.Grado;
import pe.edu.upeu.syscaso.service.GradoService;

@Service
public class GradoServiceImpl implements GradoService{
	
	@Autowired
	private GradoDao dao;
	@Override
	public Grado create(Grado a) {
		// TODO Auto-generated method stub
		return dao.create(a);
	}

	@Override
	public Grado update(Grado a) {
		// TODO Auto-generated method stub
		return dao.update(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
		
	}

	@Override
	public Optional<Grado> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Grado> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
