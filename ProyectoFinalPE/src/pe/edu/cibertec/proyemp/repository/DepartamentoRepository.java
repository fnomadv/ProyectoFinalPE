package pe.edu.cibertec.proyemp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.proyemp.model.Departamento;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Long>{

}
