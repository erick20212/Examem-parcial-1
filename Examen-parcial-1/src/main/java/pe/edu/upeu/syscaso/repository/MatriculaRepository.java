package pe.edu.upeu.syscaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.syscaso.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Long>{

}
