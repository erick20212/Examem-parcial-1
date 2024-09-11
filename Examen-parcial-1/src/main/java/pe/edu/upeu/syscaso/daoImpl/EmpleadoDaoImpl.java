package pe.edu.upeu.syscaso.daoImpl;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.syscaso.dao.EmpleadoDao;
import pe.edu.upeu.syscaso.entity.Empleado;
import pe.edu.upeu.syscaso.service.EmpleadoService;


@Component

public class EmpleadoDaoImpl implements EmpleadoService{

	@Autowired
	private EmpleadoDao dao;
	@Override
	public Empleado create(Empleado a) {
		// TODO Auto-generated method stub
		return dao.create(a);
	}

	@Override
	public Empleado update(Empleado a) {
		// TODO Auto-generated method stub
		return dao.update(a);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
		
	}

	@Override
	public Optional<Empleado> read(Long id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public List<Empleado> readAll() {
		// TODO Auto-generated method stub
		return dao.readAll();
	}

}
